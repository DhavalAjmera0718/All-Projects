package com.example.Demat.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor(staticName = "allStatic")
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "Demat_Info")
public class Demat_MainEntity {
	@Id
	private Long did;
	private String name;
	private Long sprice;

}
