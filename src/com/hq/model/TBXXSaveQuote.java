package com.hq.model;

import cn.com.hq.util.StringUtil;

public class TBXXSaveQuote {

	private String Source                ;
	private String CheSun                ;
	private String SanZhe                ;
	private String DaoQiang              ;
	private String SiJi                  ;
	private String ChengKe               ;
	private String BoLi                  ;
	private String HuaHen                ;
	private String SheShui               ;
	private String ZiRan                 ;
	private String BuJiMianCheSun        ;
	private String BuJiMianSanZhe        ;
	private String BuJiMianDaoQiang      ;
	private String BuJiMianChengKe       ;
	private String BuJiMianSiJi          ;
	private String BuJiMianHuaHen        ;
	private String BuJiMianSheShui       ;
	private String BuJiMianZiRan         ;
	private String BuJiMianJingShenSunShi;
	private String HcSanFangTeYue        ;
	private String HcJingShenSunShi      ;
	private String HcXiuLiChang          ;
	private String HcXiuLiChangType      ;
	private String Fybc                  ;
	private String FybcDays              ;
	private String SheBeiSunShi          ;
	private String BjmSheBeiSunShi       ;
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		switch (source) {
			case "1": Source="太平洋";break;
			case "2": Source="平安";break;
			case "4": Source="人保";break;
			case "8": Source="国寿财";break;
			case "16": Source="中华联合";break;
			case "32": Source="大地";break;
			case "64": Source="阳光";break;
			case "128": Source="太平保险";break;
			case "256": Source="华安";break;
			case "512": Source="天安";break;
			case "1024": Source="英大";break;
			case "2048": Source="安盛天平";break;
		}
	}
	public String getCheSun() {
		return CheSun;
	}
	public void setCheSun(String cheSun) {
		if(!StringUtil.isEmpty(cheSun)){
			CheSun = Double.valueOf(cheSun)/100 + "";
		}
	}
	public String getSanZhe() {
		return SanZhe;
	}
	public void setSanZhe(String sanZhe) {
		if(!StringUtil.isEmpty(sanZhe)){
			SanZhe = Double.valueOf(sanZhe)/100 + "";
		}
	}
	public String getDaoQiang() {
		return DaoQiang;
	}
	public void setDaoQiang(String daoQiang) {
		if(!StringUtil.isEmpty(daoQiang)){
			DaoQiang = Math.round(Double.valueOf(daoQiang)/100) + "";
		}
	}
	public String getSiJi() {
		return SiJi;
	}
	public void setSiJi(String siJi) {
		if(!StringUtil.isEmpty(siJi)){
			SiJi = Double.valueOf(siJi)/100 + "";
		}
	}
	public String getChengKe() {
		return ChengKe;
	}
	public void setChengKe(String chengKe) {
		if(!StringUtil.isEmpty(chengKe)){
			ChengKe = Double.valueOf(chengKe)/100 + "";
		}
	}
	public String getBoLi() {
		return BoLi;
	}
	public void setBoLi(String boLi) {
		BoLi = boLi;
			switch (boLi) {
			case "0": BoLi="不投保";break;
			case "1": BoLi="1国产";break;
			case "2": BoLi="进口";break;
		}
	}
	public String getHuaHen() {
		return HuaHen;
	}
	public void setHuaHen(String huaHen) {
		if(!StringUtil.isEmpty(huaHen)){
			HuaHen = Double.valueOf(huaHen)/100 + "";
		}
	}
	public String getSheShui() {
		return SheShui;
	}
	public void setSheShui(String sheShui) {
		if(!StringUtil.isEmpty(sheShui)){
			SheShui = Double.valueOf(sheShui)/100 + "";
		}
	}
	public String getZiRan() {
		return ZiRan;
	}
	public void setZiRan(String ziRan) {
		if(!StringUtil.isEmpty(ziRan)){
			ZiRan = Double.valueOf(ziRan)/100 + "";
		}
	}
	public String getBuJiMianCheSun() {
		return BuJiMianCheSun;
	}
	public void setBuJiMianCheSun(String buJiMianCheSun) {
		if(!StringUtil.isEmpty(buJiMianCheSun)){
			BuJiMianCheSun = Double.valueOf(buJiMianCheSun)/100 + "";
		}
	}
	public String getBuJiMianSanZhe() {
		return BuJiMianSanZhe;
	}
	public void setBuJiMianSanZhe(String buJiMianSanZhe) {
		if(!StringUtil.isEmpty(buJiMianSanZhe)){
			BuJiMianSanZhe = Double.valueOf(buJiMianSanZhe)/100 + "";
		}
	}
	public String getBuJiMianDaoQiang() {
		return BuJiMianDaoQiang;
	}
	public void setBuJiMianDaoQiang(String buJiMianDaoQiang) {
		if(!StringUtil.isEmpty(buJiMianDaoQiang)){
			BuJiMianDaoQiang = Double.valueOf(buJiMianDaoQiang)/100 + "";
		}
	}
	public String getBuJiMianChengKe() {
		return BuJiMianChengKe;
	}
	public void setBuJiMianChengKe(String buJiMianChengKe) {
		if(!StringUtil.isEmpty(buJiMianChengKe)){
			BuJiMianChengKe = Double.valueOf(buJiMianChengKe)/100 + "";
		}
	}
	public String getBuJiMianSiJi() {
		return BuJiMianSiJi;
	}
	public void setBuJiMianSiJi(String buJiMianSiJi) {
		if(!StringUtil.isEmpty(buJiMianSiJi)){
			BuJiMianSiJi = Double.valueOf(buJiMianSiJi)/100 + "";
		}
	}
	public String getBuJiMianHuaHen() {
		return BuJiMianHuaHen;
	}
	public void setBuJiMianHuaHen(String buJiMianHuaHen) {
		if(!StringUtil.isEmpty(buJiMianHuaHen)){
			BuJiMianHuaHen = Double.valueOf(buJiMianHuaHen)/100 + "";
		}
	}
	public String getBuJiMianSheShui() {
		return BuJiMianSheShui;
	}
	public void setBuJiMianSheShui(String buJiMianSheShui) {
		if(!StringUtil.isEmpty(buJiMianSheShui)){
			BuJiMianSheShui = Double.valueOf(buJiMianSheShui)/100 + "";
		}
	}
	public String getBuJiMianZiRan() {
		return BuJiMianZiRan;
	}
	public void setBuJiMianZiRan(String buJiMianZiRan) {
		if(!StringUtil.isEmpty(buJiMianZiRan)){
			BuJiMianZiRan = Double.valueOf(buJiMianZiRan)/100 + "";
		}
	}
	public String getBuJiMianJingShenSunShi() {
		return BuJiMianJingShenSunShi;
	}
	public void setBuJiMianJingShenSunShi(String buJiMianJingShenSunShi) {
		if(!StringUtil.isEmpty(buJiMianJingShenSunShi)){
			BuJiMianJingShenSunShi = Double.valueOf(buJiMianJingShenSunShi)/100 + "";
		}
	}
	public String getHcSanFangTeYue() {
		return HcSanFangTeYue;
	}
	public void setHcSanFangTeYue(String hcSanFangTeYue) {
		if(!StringUtil.isEmpty(hcSanFangTeYue)){
			HcSanFangTeYue = Double.valueOf(hcSanFangTeYue)/100 + "";
		}
	}
	public String getHcJingShenSunShi() {
		return HcJingShenSunShi;
	}
	public void setHcJingShenSunShi(String hcJingShenSunShi) {
		if(!StringUtil.isEmpty(hcJingShenSunShi)){
			HcJingShenSunShi = Double.valueOf(hcJingShenSunShi)/100 + "";
		}
	}
	public String getHcXiuLiChang() {
		return HcXiuLiChang;
	}
	public void setHcXiuLiChang(String hcXiuLiChang) {
		HcXiuLiChang = hcXiuLiChang;
	}
	public String getHcXiuLiChangType() {
		return HcXiuLiChangType;
	}
	public void setHcXiuLiChangType(String hcXiuLiChangType) {
		HcXiuLiChangType = hcXiuLiChangType;
		switch (hcXiuLiChangType) {
		case "-1": HcXiuLiChangType="不投保";break;
		case "0": HcXiuLiChangType="国产";break;
		case "1": HcXiuLiChangType="进口";break;
	}
	}
	public String getFybc() {
		return Fybc;
	}
	public void setFybc(String fybc) {
		Fybc = fybc;
	}
	public String getFybcDays() {
		return FybcDays;
	}
	public void setFybcDays(String fybcDays) {
		FybcDays = fybcDays;
	}
	public String getSheBeiSunShi() {
		return SheBeiSunShi;
	}
	public void setSheBeiSunShi(String sheBeiSunShi) {
		SheBeiSunShi = sheBeiSunShi;
	}
	public String getBjmSheBeiSunShi() {
		return BjmSheBeiSunShi;
	}
	public void setBjmSheBeiSunShi(String bjmSheBeiSunShi) {
		if(!StringUtil.isEmpty(bjmSheBeiSunShi)){
			BjmSheBeiSunShi = Double.valueOf(bjmSheBeiSunShi)/100 + "";
		}
	}
	
	

}
