package com.qualitesoft.channelgatesip.testdata;

import com.qualitesoft.core.InitializeTest;
import com.qualitesoft.core.Xls_Reader;

public class ProductData extends InitializeTest{

	Xls_Reader xr1=new Xls_Reader("testdata/CGFiles/ChannelGateTestData.xlsx");
	int i=Integer.parseInt(Row);
	
	public String getProductTitle() {
		return xr1.getCellData("Add Product", "Product Title", i);
	}
	public String getProductBrand() {
		return xr1.getCellData("Add Product", "Brand", i);
	}
	public String getCollections() {
		return xr1.getCellData("Add Product", "Collections", i);
	}
	public String getCategory() {
		return xr1.getCellData("Add Product", "Category", i);
	}
	public String getSku() {
		return xr1.getCellData("Add Product", "SKU", i);
	}
	public String getUpcCode() {
		return xr1.getCellData("Add Product", "UPC", i);
	}
	public String getManufactureCountry() {
		return xr1.getCellData("Add Product", "Country of Manufacture", i);
	}
	public String getWholesalePrice() {
		return xr1.getCellData("Add Product", "Wholesale", i);
	}
	public String getFreight() {
		return xr1.getCellData("Add Product", "Freight", i);
	}
	public String getMsrpPrice() {
		return xr1.getCellData("Add Product", "MSRP", i);
	}
	public String getMapPrice() {
		return xr1.getCellData("Add Product", "MAP", i);
	}
	public String getColor() {
		return xr1.getCellData("Add Product", "Color", i);
	}
	
	public String getMaterial() {
		return xr1.getCellData("Add Product", "Material", i);
	}
	public String getStyle() {
		return xr1.getCellData("Add Product", "Style", i);
	}
	public String getShortDescription() {
		return xr1.getCellData("Add Product", "Short Description", i);
	}
	public String getFeature1() {
		return xr1.getCellData("Add Product", "Feature 1", i);
	}
	public String getFeature2() {
		return xr1.getCellData("Add Product", "Feature 2", i);
	}
	public String getFeature3() {
		return xr1.getCellData("Add Product", "Feature 3", i);
	}
	public String getKey1() {
		return xr1.getCellData("Add Product", "Key1", i);
	}
	public String getValue1() {
		return xr1.getCellData("Add Product", "Value1", i);
	}
	public String getKey2() {
		return xr1.getCellData("Add Product", "Key2", i);
	}
	public String getValue2() {
		return xr1.getCellData("Add Product", "Value2", i);
	}
	public String getKey3() {
		return xr1.getCellData("Add Product", "Key3", i);
	}
	public String getValue3() {
		return xr1.getCellData("Add Product", "Value3", i);
	}
	
	public String getAvailableQuantity() {
		return xr1.getCellData("Add Product", "Available Quantity", i);
	}
	public String getShippingService() {
		return xr1.getCellData("Add Product", "Shipping Service", i);
	}
	public String getMinLeadTime() {
		return xr1.getCellData("Add Product", "Min Lead Time", i);
	}
	public String getMaxLeadTime() {
		return xr1.getCellData("Add Product", "Max Lead Time", i);
	}
	public String getHsCode() {
		return xr1.getCellData("Add Product", "HS Code", i);
	}
	public String getHeight() {
		return xr1.getCellData("Add Product", "Height", i);
	}
	public String getWidth() {
		return xr1.getCellData("Add Product", "Width", i);
	}
	public String getDepth() {
		return xr1.getCellData("Add Product", "Depth", i);
	}
	public String getWeight() {
		return xr1.getCellData("Add Product", "Weight", i);
	}
	public String getPackageHeight() {
		return xr1.getCellData("Add Product", "Package Height", i);
	}
	public String getPackageWidth() {
		return xr1.getCellData("Add Product", "Package Width", i);
	}
	public String getPackageDepth() {
		return xr1.getCellData("Add Product", "Package Depth", i);
	}
	
	public String getPackageWeight() {
		return xr1.getCellData("Add Product", "Package Weight", i);
	}
	public String getQty() {
		return xr1.getCellData("Add Product", "Qty", i);
	}
	public String getPackageType() {
		return xr1.getCellData("Add Product", "Package Type", i);
	}
	public String getPackageSKU() {
		return xr1.getCellData("Add Product", "Package SKU", i);
	}
	public String getContentScore() {
		return xr1.getCellData("Add Product", "Content Score", i);
	}
	
}
