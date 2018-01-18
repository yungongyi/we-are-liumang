package cn.tuyuan.commonweal.pojo;

// Generated 2017-12-26 15:38:16 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Resource generated by hbm2java
 */
@Entity
@Table(name = "resource", catalog = "commonweal")
public class Resource implements java.io.Serializable {

	private static final long serialVersionUID = -2060546509363000437L;
	private Integer resourceId;
	private String resourcePath;
	private Type type;
	private State state;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "resourceId", unique = true, nullable = false)
	public Integer getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	@Column(name = "resourcePath", length = 100)
	public String getResourcePath() {
		return this.resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="typeId")
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@ManyToOne
	@JoinColumn(name="typeState")
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	
}
