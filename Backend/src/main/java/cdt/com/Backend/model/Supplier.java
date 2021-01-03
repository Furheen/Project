package cdt.com.Backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Supplier {

	@Id
	@GeneratedValue
   int SupId;
   String supName;
   String supAddress;
public int getSupId() {
	return SupId;
}
public void setSupId(int supId) {
	SupId = supId;
}
public String getSupName() {
	return supName;
}
public void setSupName(String supName) {
	this.supName = supName;
}
public String getSupAddress() {
	return supAddress;
}
public void setSupAddress(String supAddress) {
	this.supAddress = supAddress;
}
   
}
