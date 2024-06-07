package com.User.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor	
public class Marks_Entity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private Long maths;
	
	private Long science;
	
	private Long economics;
	
	private Long english;
	
	private Long gujrati;
	
	private Double sum;
	
	private String grade;

	 @PrePersist
	    public void prePersist() {
	        calculateSum();
	        calculateGrade();
	    }

	    // Calculate sum and grade before updating the entity
	    @PreUpdate
	    public void preUpdate() {
	        calculateSum();
	        calculateGrade();
	    }

	    // Method to calculate the sum of marks
	    private void calculateSum() {
	        sum = (double) (maths + science + economics + english + gujrati);
	    }

	    // Method to calculate the grade based on the total marks
	    private void calculateGrade() {
	        // Logic to calculate the grade based on the total marks
	        // Example logic, you can adjust it according to your grading criteria
	        double percentage = (sum / 500) * 100;
	        if (percentage >= 90) {
	            grade = "A+";
	        } else if (percentage >= 80) {
	            grade = "A";
	        } else if (percentage >= 70) {
	            grade = "B";
	        } else if (percentage >= 60) {
	            grade = "C";
	        } else if (percentage >= 50) {
	            grade = "D";
	        } else {
	            grade = "FAIL";
	        }
	    }
}
