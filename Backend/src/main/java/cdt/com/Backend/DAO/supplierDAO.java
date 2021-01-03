package cdt.com.Backend.DAO;

import java.util.List;

import cdt.com.Backend.model.Supplier;

public interface supplierDAO {

	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public Supplier getSupplier(Supplier supplier);
public List<Supplier> listSupplier();
}
