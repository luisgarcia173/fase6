package br.com.fiap.fase6.domain.datainfo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class DataInfo implements Serializable {

  @Id
  private Long id;

  private DataInfoStatusEnum status;
  private String info;

}
