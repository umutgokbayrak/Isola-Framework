package isola.model;

import java.sql.Timestamp;
import java.util.Date;

public class JsonDateSampleItem {
	private int id;
	private String name;
	private Date dtSample;
	private Timestamp tsSample;
	
	public JsonDateSampleItem() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDtSample() {
		return dtSample;
	}

	public void setDtSample(Date dtSample) {
		this.dtSample = dtSample;
	}

	public Timestamp getTsSample() {
		return tsSample;
	}

	public void setTsSample(Timestamp tsSample) {
		this.tsSample = tsSample;
	}
	
	
}
