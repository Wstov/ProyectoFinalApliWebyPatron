/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.infrastructure.adapter;

import java.io.IOException;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Wstov
 */
public interface ReportRepository {

    public ResponseEntity<Resource>
            getReport(
                    String report,
                    Map<String, Object> parametros,
                    String tipo
            )  throws IOException;

}
