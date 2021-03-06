﻿package cn.tuyuan.commonweal.serviceimpl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tuyuan.commonweal.dao.PersonDao;
import cn.tuyuan.commonweal.pojo.Person;
import cn.tuyuan.commonweal.service.PersonService;
/**
 * 
 * @author 孙家伟
 * @version 1.0
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Resource
	private PersonDao personDao;

	
	// 根据用户id(景子铭) 
	@Override
	public Person getpersonbyId(Integer personId) {
		return personDao.getPersonbyId(personId);
	}
	//登录
	public Person getPerson(String iphone, String password) {
		//根据数据好查询用户
		Person person = personDao.getPerson(iphone);
		//如果查询到该用户
		if(person!=null){
			//验证该用户的密码是否正确
			if(person.getPassword().equals(password)){
				//如果正确则返回该用户对象
				return  person;
			}
		}
		//否则返回false
		return null;
	}


	//快速登录
	public Person fastLogin(String iphone) {
		//根据数据好查询用户
		Person person = personDao.getPerson(iphone);
		return person;
	}
	//用户注册 
	


	//根据手机号码判断用户
	public boolean getPersonById(String iphone) { 
		
		return personDao.getPersonByid(iphone);
	}
 
	public int savePerson(Person person) {
	     return   personDao.savePerson(person); 
	}


// 根据用户id(景子铭)
	@Override
	public String getPerson(Integer personId) {
		return personDao.getPerson(personId);
	}
	//修改用户密码
	public boolean updatePersonPassword(Integer personId,String password) { 
		try {
			personDao.updatePersonPassword( personId, password);
			//true为修改成功
			return true;
		} catch (Exception e) {
			e.getMessage();
			//false修改失败
			return false;
		}
	}


	//修改用户信息
	public boolean updatePerson(Person person) {
		try {
			personDao.updatePerson(person);
			//true为修改成功
			return true;
		} catch (Exception e) {
			e.getMessage();
			//false修改失败
			return false;
		}
	}


	//根据用户手机号查询用户对象
	public Person getPersonByPhone(String iphone) {
		  Person person = personDao.getPerson(iphone);
		return person;
	}
	
	/**
	 * 查询所有用户
	 */
	@Override
	public List<Person> getPerson() {
		return personDao.getPerson();
	}
	
	/**
	 * 根据手机号查询用户信息
	 */
	@Override
	public List<Person> getPersonByiphone(String iphone) {
		return personDao.getPersonByiphone(iphone);
	}
	
	/**
	 * 根据用户id查看用户信息
	 */
	@Override
	public List<Person> getPersonBypersonid(Integer id) {
		return personDao.getPersonBypersonid(id);
	}
	
	/**
	 * 修改用户状态
	 */
	@Override
	public void updatePersonBystate(int pid,int sid) {
		personDao.updatePersonBystate(pid,sid);
	}

}
