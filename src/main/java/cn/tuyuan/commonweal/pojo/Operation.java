package cn.tuyuan.commonweal.pojo;

// Generated 2017-12-26 15:38:16 by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Operation generated by hbm2java
 */
@Entity
@Table(name = "operation", catalog = "commonweal")
public class Operation implements java.io.Serializable {

	private Integer operationId;
	private Integer tableId;
	private Integer personId;
	private Type type;
	private Date operationDate;
	private String operationNote;

	public Operation() {
	}
	
	
	public Operation(Integer operationId, Integer tableId, Integer personId,
			Type type, Date operationDate, String operationNote) {
		super();
		this.operationId = operationId;
		this.tableId = tableId;
		this.personId = personId;
		this.type = type;
		this.operationDate = operationDate;
		this.operationNote = operationNote;
	}


	@Column(name = "operationPersonId")
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	@Column(name="tableId")
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "operationId", unique = true, nullable = false)
	public Integer getOperationId() {
		return this.operationId;
	}

	public void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}


	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typeId")
	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "operationDate", length = 19)
	public Date getOperationDate() {
		return this.operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	@Column(name = "operationNote", length = 50)
	public String getOperationNote() {
		return this.operationNote;
	}

	public void setOperationNote(String operationNote) {
		this.operationNote = operationNote;
	}

}
