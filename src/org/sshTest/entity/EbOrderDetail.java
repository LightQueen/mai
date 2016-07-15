package org.sshTest.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="easybuy_order_detail")
public class EbOrderDetail {
	private Integer eod_id;
	private Integer eo_id;
	private Integer ep_id;
	private Integer eod_quantity;
	private Double eod_cost;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getEod_id() {
		return eod_id;
	}

	public void setEod_id(Integer eod_id) {
		this.eod_id = eod_id;
	}

	public Integer getEo_id() {
		return eo_id;
	}

	public void setEo_id(Integer eo_id) {
		this.eo_id = eo_id;
	}

	public Integer getEp_id() {
		return ep_id;
	}

	public void setEp_id(Integer ep_id) {
		this.ep_id = ep_id;
	}

	public Integer getEod_quantity() {
		return eod_quantity;
	}

	public void setEod_quantity(Integer eod_quantity) {
		this.eod_quantity = eod_quantity;
	}

	public Double getEod_cost() {
		return eod_cost;
	}

	public void setEod_cost(Double eod_cost) {
		this.eod_cost = eod_cost;
	}
}
