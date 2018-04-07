package com.hq.model;

public class CLZTResult {

	private String isQuerySimple;
	private String variety    ;
	private String passengers ;
	private String plate      ;
	private String brand      ;
	private String type       ;
	private String vin        ;
	private String engine     ;
	private String vehicleType;
	private String color      ;
	private String properties ;
	private String man        ;
	private String record     ;
	private String validity   ;
	private String retirement ;
	private String state      ;
	private String engineType ;
	private String fuel       ;
	private String cc         ;
	private String pps        ;
	private String MaxJourney ;
	private String shaft      ;
	private String wheelBase  ;
	private String frontTread ;
	private String rearTread  ;
	private String crossWeight;
	private String curbWeight ;
	private String loadWeight ;
	
	
	
	public String getIsQuerySimple() {
		return isQuerySimple;
	}
	public void setIsQuerySimple(String isQuerySimple) {
		this.isQuerySimple = isQuerySimple;
	}
	public String getMaxJourney() {
		return MaxJourney;
	}
	public void setMaxJourney(String maxJourney) {
		MaxJourney = maxJourney;
	}
	public String getShaft() {
		return shaft;
	}
	public void setShaft(String shaft) {
		this.shaft = shaft;
	}
	public String getWheelBase() {
		return wheelBase;
	}
	public void setWheelBase(String wheelBase) {
		this.wheelBase = wheelBase;
	}
	public String getFrontTread() {
		return frontTread;
	}
	public void setFrontTread(String frontTread) {
		this.frontTread = frontTread;
	}
	public String getRearTread() {
		return rearTread;
	}
	public void setRearTread(String rearTread) {
		this.rearTread = rearTread;
	}
	public String getCrossWeight() {
		return crossWeight;
	}
	public void setCrossWeight(String crossWeight) {
		this.crossWeight = crossWeight;
	}
	public String getCurbWeight() {
		return curbWeight;
	}
	public void setCurbWeight(String curbWeight) {
		this.curbWeight = curbWeight;
	}
	public String getLoadWeight() {
		return loadWeight;
	}
	public void setLoadWeight(String loadWeight) {
		this.loadWeight = loadWeight;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		switch (state) {
		case "A":this.state="正常"   ; break;
		case "B":this.state="转出"   ; break;
		case "C":this.state="被盗抢"   ; break;
		case "D":this.state="停驶"   ; break;
		case "E":this.state="注销"   ; break;
		case "G":this.state="违法未处理"   ; break;
		case "H":this.state="海关监管"   ; break;
		case "I":this.state="事故未处理"   ; break;
		case "J":this.state="嫌疑车"   ; break;
		case "K":this.state="查封"   ; break;
		case "L":this.state="暂扣"   ; break;
		case "M":this.state="强制注销"   ; break;
		case "N":this.state="事故逃逸"   ; break;
		case "O":this.state="锁定"   ; break;
		case "P":this.state="机动车达到报废标准，公告牌作废"   ; break;
		case "Q":this.state=" 逾期未检验"   ; break;
		default : this.state = state;
		}
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getPps() {
		return pps;
	}
	public void setPps(String pps) {
		this.pps = pps;
	}
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		switch (properties) {
		case "A":this.properties="非营运"   ; break;
		case "B":this.properties="公路客运"   ; break;
		case "C":this.properties="公交客运"   ; break;
		case "D":this.properties="出租客运"   ; break;
		case "E":this.properties="旅游客运"   ; break;
		case "F":this.properties="货运"   ; break;
		case "G":this.properties="租赁"   ; break;
		case "H":this.properties="警用"   ; break;
		case "I":this.properties="消防"   ; break;
		case "J":this.properties="救护"   ; break;
		case "K":this.properties="工程救险"   ; break;
		case "L":this.properties="营转非"   ; break;
		case "M":this.properties="出租转非"   ; break;
		case "N":this.properties="教练"   ; break;
		case "O":this.properties="幼儿校车"   ; break;
		case "P":this.properties="小学生校车"   ; break;
		case "Q":this.properties="初中生校车"   ; break;
		case "R":this.properties="危化品运输"   ; break;
		case "S":this.properties="中小学生校车"   ; break;
		default : this.properties = properties;
		}
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public String getEngineType() {
		return engineType;
	}
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public String getPassengers() {
		return passengers;
	}
	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}
	public String getRetirement() {
		return retirement;
	}
	public void setRetirement(String retirement) {
		this.retirement = retirement;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		switch (color) {
		case "A":this.color="白"   ; break;
		case "B":this.color="灰"   ; break;
		case "C":this.color="黄"   ; break;
		case "D":this.color="粉"   ; break;
		case "E":this.color="红"   ; break;
		case "F":this.color="紫"   ; break;
		case "G":this.color="绿"   ; break;
		case "H":this.color="蓝"   ; break;
		case "I":this.color="棕"   ; break;
		case "J":this.color="黑"   ; break;
		default : this.color = color;
		}
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		switch (fuel) {
			case "A":this.fuel="汽油"   ; break;
			case "B":this.fuel="柴油"   ; break;
			case "C":this.fuel="电驱动"   ; break;
			case "D":this.fuel="混合油"   ; break;
			case "E":this.fuel="天然气"   ; break;
			case "F":this.fuel="液化石油气"   ; break;
			case "L":this.fuel="甲醇"   ; break;
			case "M":this.fuel="乙醇"   ; break;
			case "N":this.fuel="太阳能"   ; break;
			case "O":this.fuel="混合动力"   ; break;
			case "Y":this.fuel="无"   ; break;
			case "Z":this.fuel="其他"   ; break;
			default : this.fuel = fuel;
		}
	
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		switch (vehicleType) {
		case "B11":this.vehicleType="重型普通半挂车"   ; break;
		case "B12":this.vehicleType="重型厢式半挂车"   ; break;
		case "B13":this.vehicleType="重型罐式半挂车"   ; break;
		case "B14":this.vehicleType="重型平板半挂车"   ; break;
		case "B15":this.vehicleType="重型集装箱半挂车"   ; break;
		case "B16":this.vehicleType="重型自卸半挂车"   ; break;
		case "B17":this.vehicleType="重型特殊结构半挂车"   ; break;
		case "B18":this.vehicleType="重型仓栅式半挂车"   ; break;
		case "B19":this.vehicleType="重型旅居半挂车"   ; break;
		case "B1A":this.vehicleType="重型专项作业半挂车"   ; break;
		case "B1B":this.vehicleType="重型低平板半挂车"   ; break;
		case "B21":this.vehicleType="中型普通半挂车"   ; break;
		case "B22":this.vehicleType="中型厢式半挂车"   ; break;
		case "B23":this.vehicleType="中型罐式半挂车"   ; break;
		case "B24":this.vehicleType="中型平板半挂车"   ; break;
		case "B25":this.vehicleType="中型集装箱半挂车"   ; break;
		case "B26":this.vehicleType="中型自卸半挂车"   ; break;
		case "B27":this.vehicleType="中型特殊结构半挂车"   ; break;
		case "B28":this.vehicleType="中型仓栅式半挂车"   ; break;
		case "B29":this.vehicleType="中型旅居半挂车"   ; break;
		case "B2A":this.vehicleType="中型专项作业半挂车"   ; break;
		case "B2B":this.vehicleType="中型低平板半挂车"   ; break;
		case "B31":this.vehicleType="轻型普通半挂车"   ; break;
		case "B32":this.vehicleType="轻型厢式半挂车"   ; break;
		case "B33":this.vehicleType="轻型罐式半挂车"   ; break;
		case "B34":this.vehicleType="轻型平板半挂车"   ; break;
		case "B35":this.vehicleType="轻型自卸半挂车"   ; break;
		case "B36":this.vehicleType="轻型仓栅式半挂车"   ; break;
		case "B37":this.vehicleType="轻型旅居半挂车"   ; break;
		case "B38":this.vehicleType="轻型专项作业半挂车"   ; break;
		case "B39":this.vehicleType="轻型低平板半挂车"   ; break;
		case "D11":this.vehicleType="无轨电车"   ; break;
		case "D12":this.vehicleType="有轨电车"   ; break;
		case "G11":this.vehicleType="重型普通全挂车"   ; break;
		case "G12":this.vehicleType="重型厢式全挂车"   ; break;
		case "G13":this.vehicleType="重型罐式全挂车"   ; break;
		case "G14":this.vehicleType="重型平板全挂车"   ; break;
		case "G15":this.vehicleType="重型集装箱全挂车"   ; break;
		case "G16":this.vehicleType="重型自卸全挂车"   ; break;
		case "G17":this.vehicleType="重型仓栅式全挂车"   ; break;
		case "G18":this.vehicleType="重型旅居全挂车"   ; break;
		case "G19":this.vehicleType="重型专项作业全挂车"   ; break;
		case "G21":this.vehicleType="中型普通全挂车"   ; break;
		case "G22":this.vehicleType="中型厢式全挂车"   ; break;
		case "G23":this.vehicleType="中型罐式全挂车"   ; break;
		case "G24":this.vehicleType="中型平板全挂车"   ; break;
		case "G25":this.vehicleType="中型集装箱全挂车"   ; break;
		case "G26":this.vehicleType="中型自卸全挂车"   ; break;
		case "G27":this.vehicleType="中型仓栅式全挂车"   ; break;
		case "G28":this.vehicleType="中型旅居全挂车"   ; break;
		case "G29":this.vehicleType="中型专项作业全挂车"   ; break;
		case "G31":this.vehicleType="轻型普通全挂车"   ; break;
		case "G32":this.vehicleType="轻型厢式全挂车"   ; break;
		case "G33":this.vehicleType="轻型罐式全挂车"   ; break;
		case "G34":this.vehicleType="轻型平板全挂车"   ; break;
		case "G35":this.vehicleType="轻型自卸全挂车"   ; break;
		case "G36":this.vehicleType="轻型仓栅式全挂车"   ; break;
		case "G37":this.vehicleType="轻型旅居全挂车"   ; break;
		case "G38":this.vehicleType="轻型专项作业全挂车"   ; break;
		case "H11":this.vehicleType="重型普通货车"   ; break;
		case "H12":this.vehicleType="重型厢式货车"   ; break;
		case "H13":this.vehicleType="重型封闭货车"   ; break;
		case "H14":this.vehicleType="重型罐式货车"   ; break;
		case "H15":this.vehicleType="重型平板货车"   ; break;
		case "H16":this.vehicleType="重型集装厢车"   ; break;
		case "H17":this.vehicleType="重型自卸货车"   ; break;
		case "H18":this.vehicleType="重型特殊结构货车"   ; break;
		case "H19":this.vehicleType="重型仓栅式货车"   ; break;
		case "H21":this.vehicleType="中型普通货车"   ; break;
		case "H22":this.vehicleType="中型厢式货车"   ; break;
		case "H23":this.vehicleType="中型封闭货车"   ; break;
		case "H24":this.vehicleType="中型罐式货车"   ; break;
		case "H25":this.vehicleType="中型平板货车"   ; break;
		case "H26":this.vehicleType="中型集装厢车"   ; break;
		case "H27":this.vehicleType="中型自卸货车"   ; break;
		case "H28":this.vehicleType="中型特殊结构货车"   ; break;
		case "H29":this.vehicleType="中型仓栅式货车"   ; break;
		case "H31":this.vehicleType="轻型普通货车"   ; break;
		case "H32":this.vehicleType="轻型厢式货车"   ; break;
		case "H33":this.vehicleType="轻型封闭货车"   ; break;
		case "H34":this.vehicleType="轻型罐式货车"   ; break;
		case "H35":this.vehicleType="轻型平板货车"   ; break;
		case "H37":this.vehicleType="轻型自卸货车"   ; break;
		case "H38":this.vehicleType="轻型特殊结构货车"   ; break;
		case "H39":this.vehicleType="轻型仓栅式货车"   ; break;
		case "H41":this.vehicleType="微型普通货车"   ; break;
		case "H42":this.vehicleType="微型厢式货车"   ; break;
		case "H43":this.vehicleType="微型封闭货车"   ; break;
		case "H44":this.vehicleType="微型罐式货车"   ; break;
		case "H45":this.vehicleType="微型自卸货车"   ; break;
		case "H46":this.vehicleType="微型特殊结构货车"   ; break;
		case "H47":this.vehicleType="微型仓栅式货车"   ; break;
		case "H51":this.vehicleType="普通低速货车"   ; break;
		case "H52":this.vehicleType="厢式低速货车"   ; break;
		case "H53":this.vehicleType="罐式低速货车"   ; break;
		case "H54":this.vehicleType="自卸低速货车"   ; break;
		case "H55":this.vehicleType="仓栅式低速货车"   ; break;
		case "J11":this.vehicleType="轮式装载机械"   ; break;
		case "J12":this.vehicleType="轮式挖掘机械"   ; break;
		case "J13":this.vehicleType="轮式平地机械"   ; break;
		case "K11":this.vehicleType="大型普通客车"   ; break;
		case "K12":this.vehicleType="大型双层客车"   ; break;
		case "K13":this.vehicleType="大型卧铺客车"   ; break;
		case "K14":this.vehicleType="大型铰接客车"   ; break;
		case "K15":this.vehicleType="大型越野客车"   ; break;
		case "K16":this.vehicleType="大型轿车"   ; break;
		case "K17":this.vehicleType="大型专用客车"   ; break;
		case "K18":this.vehicleType="大型专用校车"   ; break;
		case "K21":this.vehicleType="中型普通客车"   ; break;
		case "K22":this.vehicleType="中型双层客车"   ; break;
		case "K23":this.vehicleType="中型卧铺客车"   ; break;
		case "K24":this.vehicleType="中型铰接客车"   ; break;
		case "K25":this.vehicleType="中型越野客车"   ; break;
		case "K26":this.vehicleType="中型轿车"   ; break;
		case "K27":this.vehicleType="中型专用客车"   ; break;
		case "K28":this.vehicleType="中型专用校车"   ; break;
		case "K31":this.vehicleType="小型普通客车"   ; break;
		case "K32":this.vehicleType="小型越野客车"   ; break;
		case "K33":this.vehicleType="小型轿车"   ; break;
		case "K34":this.vehicleType="小型专用客车"   ; break;
		case "K38":this.vehicleType="小型专用校车"   ; break;
		case "K41":this.vehicleType="微型普通客车"   ; break;
		case "K42":this.vehicleType="微型越野客车"   ; break;
		case "K43":this.vehicleType="微型轿车"   ; break;
		case "M11":this.vehicleType="普通正三轮摩托车"   ; break;
		case "M12":this.vehicleType="轻便正三轮摩托车"   ; break;
		case "M13":this.vehicleType="正三轮载客摩托车"   ; break;
		case "M14":this.vehicleType="正三轮载货摩托车"   ; break;
		case "M15":this.vehicleType="侧三轮摩托车"   ; break;
		case "M21":this.vehicleType="普通二轮摩托车"   ; break;
		case "M22":this.vehicleType="轻便二轮摩托车"   ; break;
		case "N11":this.vehicleType="三轮汽车"   ; break;
		case "Q11":this.vehicleType="重型半挂牵引车"   ; break;
		case "Q12":this.vehicleType="重型全挂牵引车"   ; break;
		case "Q21":this.vehicleType="中型半挂牵引车"   ; break;
		case "Q22":this.vehicleType="中型全挂牵引车"   ; break;
		case "Q31":this.vehicleType="轻型半挂牵引车"   ; break;
		case "Q32":this.vehicleType="轻型全挂牵引车"   ; break;
		case "T11":this.vehicleType="大型轮式拖拉机"   ; break;
		case "T21":this.vehicleType="小型轮式拖拉机"   ; break;
		case "T22":this.vehicleType="手扶拖拉机"   ; break;
		case "T23":this.vehicleType="手扶变形运输机"   ; break;
		case "X99":this.vehicleType="其它"   ; break;
		case "Z11":this.vehicleType="大型专项作业车"   ; break;
		case "Z21":this.vehicleType="中型专项作业车"   ; break;
		case "Z31":this.vehicleType="小型专项作业车"   ; break;
		case "Z41":this.vehicleType="微型专项作业车"   ; break;
		case "Z51":this.vehicleType="重型专项作业车"   ; break;
		default : this.vehicleType = vehicleType;
		}
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getMan() {
		return man;
	}
	public void setMan(String man) {
		this.man = man;
	}
	
	
	

}


