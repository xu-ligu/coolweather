package com.coolweather.app.util;

import android.text.TextUtils;
import android.util.Log;

import com.coolweather.app.db.CoolWeatherDB;
import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

public class Utility {
	
	/*
	 * �����ʹ�����������ص�ʡ����
	 * */
	public synchronized static boolean handleProvincesResponse(CoolWeatherDB 
			coolWeatherDB,String response){
		if(!TextUtils.isEmpty(response)){
			String[] allProvinces=response.split(",");
			if(allProvinces!=null&&allProvinces.length>0){
				for(String p:allProvinces){
					String[] array=p.split("\\|");
					Province province=new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					//���������������ݴ洢��Province��
					coolWeatherDB.saveProvince(province);
					Log.d("23", "23333");
				}
				return true;
			}
			
		}
		return false;
	}
	
	/*
	 * �����ʹ�����������ص��м�����
	 * */
	
	public synchronized static boolean handleCitiesResponse(CoolWeatherDB 
			coolWeatherDB,String response ,int provinceId){
		if(!TextUtils.isEmpty(response)){
			String[] allCities=response.split(",");
			if(allCities!=null&&allCities.length>0){
				for(String p:allCities){
					String[] array=p.split("\\|");
					City city=new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					//���������������ݴ洢��Province��
					coolWeatherDB.saveCity(city);
				}
				return true;
			}
			
		}
		return false;
	}
	/*
	 * �����ʹ�����������ص��ؼ�����
	 * */
	public synchronized static boolean handleCountiesResponse(CoolWeatherDB 
			coolWeatherDB,String response ,int cityId){
		if(!TextUtils.isEmpty(response)){
			String[] allCounties=response.split(",");
			if(allCounties!=null&&allCounties.length>0){
				for(String p:allCounties){
					String[] array=p.split("\\|");
					County counties=new County();  
					counties.setCountyCode(array[0]);
					counties.setCountyName(array[1]);
					counties.setCityId(cityId);
					//���������������ݴ洢��Province��
					coolWeatherDB.saveCounty(counties);
				}
				return true;
			}
			
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
