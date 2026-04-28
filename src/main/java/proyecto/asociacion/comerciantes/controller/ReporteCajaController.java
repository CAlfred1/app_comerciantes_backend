package proyecto.asociacion.comerciantes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.asociacion.comerciantes.dto.ReporteCajaDto;
import proyecto.asociacion.comerciantes.service.ReporteCajaService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.time.LocalDate;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reporte")
public class ReporteCajaController {

    private final ReporteCajaService reporteCajaService;

    public ReporteCajaController(ReporteCajaService reporteCajaService) {
        this.reporteCajaService = reporteCajaService;
    }

    // ===================
    // REPORTE POR RANGO
    // ===================
    @GetMapping("/caja-rango")
    public ResponseEntity<ReporteCajaDto> porRango(
            @RequestParam LocalDate fechaInicio,
            @RequestParam LocalDate fechaFin) {

        return ResponseEntity.ok(
                reporteCajaService.generarReporte(fechaInicio, fechaFin)
        );
    }

    // POR RANGO PDF
    @GetMapping("/caja-rango/pdf")
    public ResponseEntity<byte[]> pdfRango(
            @RequestParam LocalDate fechaInicio,
            @RequestParam LocalDate fechaFin) {

        ReporteCajaDto reporte = reporteCajaService.generarReporte(fechaInicio, fechaFin);

        byte[] pdf = reporteCajaService.generarPdf(reporte, fechaInicio, fechaFin);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "reporte_caja.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdf);
    }


    // =================
    // REPORTE MENSUAL
    // =================
    @GetMapping("/caja-mensual")
    public ResponseEntity<ReporteCajaDto> porMes(
            @RequestParam int anio,
            @RequestParam int mes) {

        return ResponseEntity.ok(
                reporteCajaService.generarReporteMensual(anio, mes)
        );
    }

    // POR MENSUAL PDF
    @GetMapping("/caja-mensual/pdf")
    public ResponseEntity<byte[]> pdfMensual(
            @RequestParam int anio,
            @RequestParam int mes) {

        LocalDate inicio = LocalDate.of(anio, mes, 1);
        LocalDate fin = inicio.plusMonths(1).minusDays(1);

        ReporteCajaDto reporte = reporteCajaService.generarReporteMensual(anio, mes);

        byte[] pdf = reporteCajaService.generarPdf(reporte, inicio, fin);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "reporte_mensual.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdf);
    }


}