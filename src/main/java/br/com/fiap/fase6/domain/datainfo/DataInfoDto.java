package br.com.fiap.fase6.domain.datainfo;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class DataInfoDto implements Serializable {

  @Id
  private Long id;

  private DataInfoStatusEnum status;
  private String info;

}
