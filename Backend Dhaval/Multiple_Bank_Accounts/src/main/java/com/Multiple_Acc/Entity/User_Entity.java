package com.Multiple_Acc.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Primary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor(staticName = "PerentStatic_Entity")
@NoArgsConstructor
@ToString
@Table( name =  "UserDetails")
@Primary
public class User_Entity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	private String username;
	
	//@JoinColumn(name = "userid" , referencedColumnName = "userId")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "BankDetails_TABLE" , 
	joinColumns = {@JoinColumn(name = "User_ID" , referencedColumnName = "userId")},
	inverseJoinColumns = {@JoinColumn(name="Bank_ID" , referencedColumnName = "bid")})
	private List<Account_Entity> accDetails;

}
