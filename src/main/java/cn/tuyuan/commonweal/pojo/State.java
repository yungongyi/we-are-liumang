package cn.tuyuan.commonweal.pojo;

// Generated 2017-12-26 15:38:16 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * State generated by hbm2java
 */
@Entity
@Table(name = "state", catalog = "commonweal")
public class State implements java.io.Serializable {

	private Integer stateId; //这是Id
	private Integer tableId;


	private String stateName;//状态名


	public State() {
	}




	public State(Integer stateId, Integer tableId, String stateName) {
		super();
		this.stateId = stateId;
		this.tableId = tableId;
		this.stateName = stateName;
	}




	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "stateId", unique = true, nullable = false)
	public Integer getStateId() {
		return this.stateId;
	}
	@Column(name="tableId")
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	@Column(name = "stateName", nullable = false, length = 50)
	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}


}
