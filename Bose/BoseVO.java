/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.bose.service;

/**
 * @Class Name : BoseVO.java
 * @Description : BoseVO Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
public class BoseVO extends BoseDefaultVO {

	private static final long serialVersionUID = 1L;

	
	/** 아이디 */
	private Integer id;
	
	/** 주민등록번호 */
	private String residentNum;

	/** 우편번호 */
	private Integer zipCode;

	/** 회원명 */
	private String userName;

	/** 생년월일 */
	private String birthDate;

	/** 성별 */
	private String gender;

	/** 양/음력 */
	private String solarLunar;

	/** 주소 */
	private String address;
	
	/** 전화(자택) */
	private String phoneHome;

	/** 전화(직장) */
	private String phoneWork;
	
	/** 휴대폰 */
	private String phoneMobile;
	
	/** 최초가입일 */
	private String regDate;
	
	/** E-mail */
	private String mail;
	
	/** 회원참고사항 */
	private String userNote;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResidentNum() {
		return residentNum;
	}

	public void setResidentNum(String residentNum) {
		this.residentNum = residentNum;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSolarLunar() {
		return solarLunar;
	}

	public void setSolarLunar(String solarLunar) {
		this.solarLunar = solarLunar;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneHome() {
		return phoneHome;
	}

	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}

	public String getPhoneWork() {
		return phoneWork;
	}

	public void setPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
	}

	public String getPhoneMobile() {
		return phoneMobile;
	}

	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUserNote() {
		return userNote;
	}

	public void setUserNote(String userNote) {
		this.userNote = userNote;
	}	
	
	
	
	
	
	
	
//	/** 아이디 */
//	private Integer id;
//	
//	/** 이름 */
//	private String name;
//
//	/** 내용 */
//	private String description;
//
//	/** 사용여부 */
//	private String useYn;
//
//	/** 등록자 */
//	private String regUser;
//	
//	/** 등록일시 */
//	private String regDate;
//
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getUseYn() {
//		return useYn;
//	}
//
//	public void setUseYn(String useYn) {
//		this.useYn = useYn;
//	}
//
//	public String getRegUser() {
//		return regUser;
//	}
//
//	public void setRegUser(String regUser) {
//		this.regUser = regUser;
//	}
//
//	public String getRegDate() {
//		return regDate;
//	}
//
//	public void setRegDate(String regDate) {
//		this.regDate = regDate;
//	}

}
