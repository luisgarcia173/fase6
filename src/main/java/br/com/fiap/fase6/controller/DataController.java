package br.com.fiap.fase6.controller;

import br.com.fiap.fase6.domain.datainfo.DataInfoDto;
import br.com.fiap.fase6.service.DataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/data")
public class DataController {

  @Autowired
  private DataService dataService;

  @Operation(summary = "Input data structure", tags = { "data" })
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Successful operation",
          content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DataInfoDto.class)) }) })
  @PostMapping("/")
  public DataInfoDto input(@Parameter(description = "Data Structure") @Valid @RequestBody final DataInfoDto data) {
    return this.dataService.input(data);
  }

}
