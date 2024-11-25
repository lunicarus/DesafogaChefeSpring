package projetos.desafogachefespring.backend.domain.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetos.desafogachefespring.backend.domain.entities.FinancialReport;
import projetos.desafogachefespring.backend.domain.services.FinancialReportService;
import projetos.desafogachefespring.backend.domain.services.PdfService;

@RestController
@RequestMapping("/financial-reports")
public class FinancialReportController {

    private final FinancialReportService financialReportService;
    private final PdfService pdfService;

    public FinancialReportController(FinancialReportService financialReportService, PdfService pdfService) {
        this.financialReportService = financialReportService;
        this.pdfService = pdfService;
    }

    @GetMapping("/{id}/pdf")
    public ResponseEntity<byte[]> generateFinancialReportPdf(@PathVariable Long id) {
        FinancialReport report = financialReportService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Financial report not found with id: " + id));

        byte[] pdfBytes = pdfService.generateFinancialReportPdf(report);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=financial_report_" + id + ".pdf")
                .body(pdfBytes);
    }
}
