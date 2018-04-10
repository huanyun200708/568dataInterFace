package com.hq.model;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import cn.com.hq.util.QueryAppKeyLib;
import cn.com.hq.util.SSLUtil;
import cn.com.hq.util.StringUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TBXXUserInfo {
	private static Logger logger = Logger.getLogger(TBXXUserInfo.class);
	private boolean isHideInfo = true;
	private String CarUsedType;
	private String LicenseNo;
	private String LicenseOwner;
	//private String InsuredName;
	//private String PostedName;
	private String IdType;
	//private String CredentislasNum;
	private String CityCode;
	private String EngineNo;
	private String ModleName;
	private String CarVin;
	private String RegisterDate;
	private String ForceExpireDate;
	private String BusinessExpireDate;
	private String NextForceStartDate;
	private String NextBusinessStartDate;
	private String PurchasePrice;
	private String SeatCount;
	private String FuelType;
	private String ProofType;
	private String LicenseColor;
	private String ClauseType;
	private String RunRegion;
	//private String InsuredIdCard;
	//private String InsuredIdType;
	//private String InsuredMobile;
	//private String HolderIdCard;
	//private String HolderIdType;
	//private String HolderMobile;
	private String RateFactor1;
	private String RateFactor2;
	private String RateFactor3;
	private String RateFactor4;
	private String IsPublic;
	private String BizNo;
	private String ForceNo;
	private String ExhaustScale;
	private String AutoMoldCode;

	public String getCarUsedType() {
		return CarUsedType;
	}
//,1:家庭自用车(默认),2:党政机关、事业团体,3:非营业企业客车,4:不区分营业非营业(仅支持人保报价),5:出租租赁(仅支持人保报价),6:营业货车(仅支持人保报价),7:非营业货车(仅支持人保报价),8: 城市公交
	public void setCarUsedType(String carUsedType) {
		if(carUsedType == null){
			CarUsedType = "";
		}
		switch (carUsedType) {
		case "2": CarUsedType="党政机关、事业团体";break;
		case "3": CarUsedType="非营业企业客车";break;
		case "4": CarUsedType="不区分营业非营业";break;
		case "5": CarUsedType="出租租赁";break;
		case "6": CarUsedType="营业货车";break;
		case "7": CarUsedType="非营业货车";break;
		case "8": CarUsedType="城市公交";break;
		default: CarUsedType = "家庭自用车"; break;
		}
	}

	public String getLicenseNo() {
		return LicenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		LicenseNo = licenseNo;
	}

	public String getLicenseOwner() {
		return LicenseOwner;
	}

	public void setLicenseOwner(String licenseOwner) {
		if(!StringUtil.isEmpty(licenseOwner) && this.isHideInfo){
			LicenseOwner = licenseOwner.substring(0, licenseOwner.length()-1)+"*";
		}else{
			LicenseOwner = licenseOwner;
		}
		
	}

	/*public String getInsuredName() {
		return InsuredName;
	}

	public void setInsuredName(String insuredName) {
		
		if(!StringUtil.isEmpty(insuredName)  && this.isHideInfo){
			InsuredName = insuredName.substring(0, insuredName.length()-1)+"*";
		}else{
			InsuredName = insuredName;
		}
	}

	public String getPostedName() {
		return PostedName;
	}

	public void setPostedName(String postedName) {
		
		if(!StringUtil.isEmpty(postedName)  && this.isHideInfo){
			PostedName = postedName.substring(0, postedName.length()-1)+"*";
		}else{
			PostedName = postedName;
		}
	}*/

	public String getIdType() {
		return IdType;
	}

	//0:没有取到,1:身份证,2: 组织机构代码证,3:护照,4:军官证,5:港澳回乡证或台胞证,6:其他,7:港澳通行证,8:出生证,9: 营业执照(社会统一信用代码),10:税务登记证
	public void setIdType(String idType) {
		if(idType == null){
			idType = "";
		}
		switch (idType) {
			case "1": IdType="身份证";break;
			case "2": IdType="组织机构代码证";break;
			case "3": IdType="护照";break;
			case "4": IdType="军官证";break;
			case "5": IdType="港澳回乡证或台胞证";break;
			case "6": IdType="其他";break;
			case "7": IdType="港澳通行证";break;
			case "8": IdType="出生证";break;
			case "9": IdType="营业执照(社会统一信用代码)";break;
			case "10": IdType="税务登记证";break;
			default: IdType = "没有取到"; break;
		}
	}

	/*public String getCredentislasNum() {
		return CredentislasNum;
	}

	public void setCredentislasNum(String credentislasNum) {
		
		if(!StringUtil.isEmpty(credentislasNum)  && this.isHideInfo){
			CredentislasNum = credentislasNum.substring(0, credentislasNum.length()-4)+"****";
		}else{
			CredentislasNum = credentislasNum;
		}
	}*/

	public String getCityCode() {
		return CityCode;
	}
	
	public CityZiDian getCityZiDian(){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").enableComplexMapKeySerialization().disableHtmlEscaping().create();
		String url =  QueryAppKeyLib.chengShiIdUrl+"key="+QueryAppKeyLib.toubaoxinxiQueryAppKey;
		HttpGet httpGet = new HttpGet(url);
        //设置请求器的配置
		try {
			HttpClient httpClient = SSLUtil.getHttpClient();
	        HttpResponse res = httpClient.execute(httpGet);
	        HttpEntity entity = res.getEntity();
	        String result = EntityUtils.toString(entity, "UTF-8");
	        System.out.println(result);
	        System.out.println("result : "+result);
	        result = result.replace("附录1", "fulu1").replace("附录2", "fulu2").replace("附录3", "fulu3").replace("附录4", "fulu4").replace("附录5", "fulu5").replace("附录6", "fulu6");
	        CityZiDian c = gson.fromJson(result, CityZiDian.class);
	        if(!"0".equals(c.getError_code())){
	        	return null;
	        }
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(StringUtil.errInfo(e));
			logger.error("城市字典查询失败");
			return null;
		}
	}
public static void main(String[] args) {
	TBXXUserInfo t = new TBXXUserInfo();
	t.setCityCode("10");
	System.out.println(t.getCityCode());
	
}
	public void setCityCode(String cityCode) {
		CityZiDian zd = getCityZiDian();
		if(zd != null){
			CityCode = zd.getResult().get(cityCode);
			return;
		}
		if(CityCode == null){
			CityCode = "";
		}
		switch (cityCode) {
			case "1"	: CityCode="北京"   ; break;
			case "10"	: CityCode="福州"   ; break;
			case "11"	: CityCode="深圳"   ; break;
			case "12"	: CityCode="石家庄" ; break;
			case "13"	: CityCode="芜湖"   ; break;
			case "14"	: CityCode="广州"   ; break;
			case "15"	: CityCode="厦门"   ; break;
			case "16"	: CityCode="苏州"   ; break;
			case "17"	: CityCode="东莞"   ; break;
			case "18"	: CityCode="济南"   ; break;
			case "19"	: CityCode="武汉"   ; break;
			case "2"	: CityCode="重庆"   ; break;
			case "20"	: CityCode="佛山"   ; break;
			case "21"	: CityCode="无锡"   ; break;
			case "22"	: CityCode="烟台"   ; break;
			case "23"	: CityCode="泰州"   ; break;
			case "25"	: CityCode="长春"   ; break;
			case "27"	: CityCode="郑州"   ; break;
			case "28"	: CityCode="青岛"   ; break;
			case "29"	: CityCode="新疆"   ; break;
			case "3"	: CityCode="天津"   ; break;
			case "32"	: CityCode="聊城"   ; break;
			case "33"	: CityCode="盐城"   ; break;
			case "34"	: CityCode="南通"   ; break;
			case "35"	: CityCode="常州"   ; break;
			case "36"	: CityCode="保定"   ; break;
			case "37"	: CityCode="沈阳"   ; break;
			case "38"	: CityCode="台州"   ; break;
			case "39"	: CityCode="盘锦"   ; break;
			case "4"	: CityCode="成都"   ; break;
			case "40"	: CityCode="嘉兴"   ; break;
			case "5"	: CityCode="昆明"   ; break;
			case "6"	: CityCode="上海"   ; break;
			case "7"	: CityCode="银川"   ; break;
			case "8"	: CityCode="南京"   ; break;
			case "9"	: CityCode="杭州"   ; break;
		}
	}

	public String getEngineNo() {
		return EngineNo;
	}

	public void setEngineNo(String engineNo) {
		EngineNo = engineNo;
	}

	public String getModleName() {
		return ModleName;
	}

	public void setModleName(String modleName) {
		ModleName = modleName;
	}

	public String getCarVin() {
		return CarVin;
	}

	public void setCarVin(String carVin) {
		CarVin = carVin;
	}

	public String getRegisterDate() {
		return RegisterDate;
	}

	public void setRegisterDate(String registerDate) {
		RegisterDate = registerDate;
	}

	public String getForceExpireDate() {
		return ForceExpireDate;
	}

	public void setForceExpireDate(String forceExpireDate) {
		ForceExpireDate = forceExpireDate;
	}

	public String getBusinessExpireDate() {
		return BusinessExpireDate;
	}

	public void setBusinessExpireDate(String businessExpireDate) {
		BusinessExpireDate = businessExpireDate;
	}

	public String getNextForceStartDate() {
		return NextForceStartDate;
	}

	public void setNextForceStartDate(String nextForceStartDate) {
		NextForceStartDate = nextForceStartDate;
	}

	public String getNextBusinessStartDate() {
		return NextBusinessStartDate;
	}

	public void setNextBusinessStartDate(String nextBusinessStartDate) {
		NextBusinessStartDate = nextBusinessStartDate;
	}

	public String getPurchasePrice() {
		return PurchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		PurchasePrice = purchasePrice;
	}

	public String getSeatCount() {
		return SeatCount;
	}

	public void setSeatCount(String seatCount) {
		SeatCount = seatCount;
	}

	public String getFuelType() {
		return FuelType;
	}

	public void setFuelType(String fuelType) {
		if(fuelType == null){
			fuelType = "";
		}
		switch (fuelType) {
			case "1"	: FuelType="汽油"   ; break;
			case "2"	: FuelType="柴油"   ; break;
			case "3"	: FuelType="电"   ; break;
			case "4"	: FuelType="混合油" ; break;
			case "5"	: FuelType="天然气"   ; break;
			case "6"	: FuelType="液化石油气"   ; break;
			case "7"	: FuelType="甲醇"   ; break;
			case "8"	: FuelType="乙醇"   ; break;
			case "9"	: FuelType="太阳能"   ; break;
			case "10"	: FuelType="混合动力"   ; break;
			default 	: FuelType="其它"   ; break;
		}
	}

	public String getProofType() {
		return ProofType;
	}

	public void setProofType(String proofType) {
		if(proofType == null){
			proofType = "";
		}
		switch (proofType) {
		case "1"	: ProofType="非营业用汽车用品"   ; break;
		case "2"	: ProofType="家庭自用汽车产品"   ; break;
		case "3"	: ProofType="营业用汽车产品"   ; break;
		case "4"	: ProofType="摩托车产品" ; break;
		case "5"	: ProofType="拖拉机产品"   ; break;
		case "6"	: ProofType="特种车产品"   ; break;
		default 	: FuelType="其它"   ; break;
	}
	}

	public String getLicenseColor() {
		return LicenseColor;
	}

	public void setLicenseColor(String licenseColor) {
		if(licenseColor == null){
			licenseColor = "";
		}
		switch (licenseColor) {
			case "1"	: LicenseColor="蓝"   ; break;
			case "2"	: LicenseColor="黑"   ; break;
			case "3"	: LicenseColor="白"   ; break;
			case "4"	: LicenseColor="黄" ; break;
			default 	: FuelType="其它"   ; break;
		}
	}

	public String getClauseType() {
		return ClauseType;
	}

	public void setClauseType(String clauseType) {
		if(clauseType == null){
			clauseType = "";
		}
		switch (clauseType) {
			case "1"	: ClauseType="销售发票"   ; break;
			case "2"	: ClauseType="法院调解书"   ; break;
			case "3"	: ClauseType="法院仲裁书"   ; break;
			case "4"	: ClauseType="法院判决书" ; break;
			case "5"	: ClauseType="仲裁裁决书"   ; break;
			case "6"	: ClauseType="相关文书"   ; break;
			case "7"	: ClauseType="批准文件"   ; break;
			case "8"	: ClauseType="调拨证明"   ; break;
			case "9"	: ClauseType="修理发票"   ; break;
			default 	: FuelType="其它"   ; break;
		}
	}

	public String getRunRegion() {
		return RunRegion;
	}

	public void setRunRegion(String runRegion) {
		if(runRegion == null){
			runRegion = "";
		}
		switch (runRegion) {
			case "1"	: RunRegion="境内"   ; break;
			case "2"	: RunRegion="本省内"   ; break;
			default 	: FuelType="其它"   ; break;
		}
	}

	/*public String getInsuredIdCard() {
		return InsuredIdCard;
	}

	public void setInsuredIdCard(String insuredIdCard) {
		
		if(!StringUtil.isEmpty(insuredIdCard)  && this.isHideInfo){
			InsuredIdCard = insuredIdCard.substring(0, insuredIdCard.length()-4)+"****";
		}else{
			InsuredIdCard = insuredIdCard;
		}
	}

	public String getInsuredIdType() {
		return InsuredIdType;
	}

	public void setInsuredIdType(String insuredIdType) {
		switch (insuredIdType) {
			case "1": InsuredIdType="身份证";break;
			case "2": InsuredIdType="组织机构代码证";break;
			case "3": InsuredIdType="护照";break;
			case "4": InsuredIdType="军官证";break;
			case "5": InsuredIdType="港澳回乡证或台胞证";break;
			case "6": InsuredIdType="其他";break;
			case "7": InsuredIdType="港澳通行证";break;
			case "8": InsuredIdType="出生证";break;
			case "9": InsuredIdType="营业执照(社会统一信用代码)";break;
			case "10": InsuredIdType="税务登记证";break;
			default: InsuredIdType = "没有取到"; break;
		}
	}

	public String getInsuredMobile() {
		return InsuredMobile;
	}

	public void setInsuredMobile(String insuredMobile) {
		
		if(!StringUtil.isEmpty(insuredMobile)  && this.isHideInfo){
			InsuredMobile = insuredMobile.substring(0, insuredMobile.length()-4)+"****";
		}else{
			InsuredMobile = insuredMobile;
		}
	}

	public String getHolderIdCard() {
		return HolderIdCard;
	}

	public void setHolderIdCard(String holderIdCard) {
		if(!StringUtil.isEmpty(holderIdCard) && this.isHideInfo){
			HolderIdCard = holderIdCard.substring(0, holderIdCard.length()-4)+"****";
		}else{
			HolderIdCard = holderIdCard;
		}
	}

	public String getHolderIdType() {
		return HolderIdType;
	}

	public void setHolderIdType(String holderIdType) {
		switch (holderIdType) {
			case "1": HolderIdType="身份证";break;
			case "2": HolderIdType="组织机构代码证";break;
			case "3": HolderIdType="护照";break;
			case "4": HolderIdType="军官证";break;
			case "5": HolderIdType="港澳回乡证或台胞证";break;
			case "6": HolderIdType="其他";break;
			case "7": HolderIdType="港澳通行证";break;
			case "8": HolderIdType="出生证";break;
			case "9": HolderIdType="营业执照(社会统一信用代码)";break;
			case "10": HolderIdType="税务登记证";break;
			default: HolderIdType = "没有取到"; break;
		}
	}

	public String getHolderMobile() {
		return HolderMobile;
	}

	public void setHolderMobile(String holderMobile) {
		if(!StringUtil.isEmpty(holderMobile) && this.isHideInfo){
			HolderMobile = holderMobile.substring(0, holderMobile.length()-4)+"****";
		}else{
			HolderMobile = holderMobile;
		}
	}
*/
	public String getRateFactor1() {
		return RateFactor1;
	}

	public void setRateFactor1(String rateFactor1) {
		RateFactor1 = rateFactor1;
	}

	public String getRateFactor2() {
		return RateFactor2;
	}

	public void setRateFactor2(String rateFactor2) {
		RateFactor2 = rateFactor2;
	}

	public String getRateFactor3() {
		return RateFactor3;
	}

	public void setRateFactor3(String rateFactor3) {
		RateFactor3 = rateFactor3;
	}

	public String getRateFactor4() {
		return RateFactor4;
	}

	public void setRateFactor4(String rateFactor4) {
		RateFactor4 = rateFactor4;
	}

	public String getIsPublic() {
		return IsPublic;
	}

	public void setIsPublic(String isPublic) {
		if(isPublic == null){
			isPublic = "";
		}
		switch (isPublic) {
			case "1"	: IsPublic="公车"   ; break;
			case "2"	: IsPublic="私车"   ; break;
			default 	: IsPublic="续保失败,无法获取该属性"   ; break;
		}
	}

	public String getBizNo() {
		return BizNo;
	}

	public void setBizNo(String bizNo) {
		BizNo = bizNo;
	}

	public String getForceNo() {
		return ForceNo;
	}

	public void setForceNo(String forceNo) {
		ForceNo = forceNo;
	}

	public String getExhaustScale() {
		return ExhaustScale;
	}

	public void setExhaustScale(String exhaustScale) {
		ExhaustScale = exhaustScale;
	}

	public String getAutoMoldCode() {
		return AutoMoldCode;
	}

	public void setAutoMoldCode(String autoMoldCode) {
		AutoMoldCode = autoMoldCode;
	}
	
	public boolean isHideInfo() {
		return isHideInfo;
	}
	public void setHideInfo(boolean isHideInfo) {
		this.isHideInfo = isHideInfo;
	}

}
