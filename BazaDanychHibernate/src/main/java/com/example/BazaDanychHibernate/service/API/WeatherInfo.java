package com.example.BazaDanychHibernate.service.API;

import java.util.ArrayList;
import java.util.List;

public class WeatherInfo {

    private  List<CrurrentCondition> current_condition = new ArrayList<>();
    private  List<NearestArea> nearest_area = new ArrayList<>();


    public WeatherInfo() {

    }

    public WeatherInfo(List<CrurrentCondition> current_condition, List<NearestArea> nearest_area) {
        this.current_condition = current_condition;
        this.nearest_area = nearest_area;

    }

    public static class NearestArea {
        private List<AreaName> areaName = new ArrayList<>();
        private List<Country> country = new ArrayList<>();
        private double latitude;
        private double longitude;

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public static class Country {
            private String value;

            @Override
            public String toString() {
                return "Country{" +
                        "value='" + value + '\'' +
                        '}';
            }

            public Country() {
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }


        public static  class AreaName {
            private String value;

            public AreaName() {
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        public List<AreaName> getAreaName() {
            return areaName;
        }

        public void setAreaName(List<AreaName> areaName) {
            this.areaName = areaName;
        }

        public List<Country> getCountry() {
            return country;
        }

        public void setCountry(List<Country> country) {
            this.country = country;
        }


        @Override
        public String toString() {
            return "NearestArea{" +
                    "areaName=" + areaName +
                    ", country=" + country +
                    '}';
        }
    }


    public static class CrurrentCondition {

        private double FeelsLikeC;
        private double cloudcover;
        private double humidity;
        private double latitude;
        private double longitude;
        private String  localObsDateTime;
        private int pressure;
        private double temp_C;
        private int uvIndex;
        private int visibility;

        @Override
        public String toString() {
            return "CrurrentCondition{" +
                    "latitude=" + latitude +
                    ", longitude=" + longitude +
                    ", localObsDateTime='" + localObsDateTime + '\'' +
                    ", pressure=" + pressure +
                    ", temp_C=" + temp_C +
                    ", uvIndex=" + uvIndex +
                    ", visibility=" + visibility +
                    '}';
        }

        public CrurrentCondition() {

        }

        public double getFeelsLikeC() {
            return FeelsLikeC;
        }

        public void setFeelsLikeC(double feelsLikeC) {
            FeelsLikeC = feelsLikeC;
        }

        public double getCloudcover() {
            return cloudcover;
        }

        public void setCloudcover(double cloudcover) {
            this.cloudcover = cloudcover;
        }

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getLocalObsDateTime() {
            return localObsDateTime;
        }

        public void setLocalObsDateTime(String localObsDateTime) {
            this.localObsDateTime = localObsDateTime;
        }

        public int getPressure() {
            return pressure;
        }

        public void setPressure(int pressure) {
            this.pressure = pressure;
        }

        public double getTemp_C() {
            return temp_C;
        }

        public void setTemp_C(double temp_C) {
            this.temp_C = temp_C;
        }

        public int getUvIndex() {
            return uvIndex;
        }

        public void setUvIndex(int uvIndex) {
            this.uvIndex = uvIndex;
        }

        public int getVisibility() {
            return visibility;
        }

        public void setVisibility(int visibility) {
            this.visibility = visibility;
        }
    }

    public List<CrurrentCondition> getCurrent_condition() {
        return current_condition;
    }

    public void setCurrent_condition(List<CrurrentCondition> current_condition) {
        this.current_condition = current_condition;
    }

    public List<NearestArea> getNearest_area() {
        return nearest_area;
    }

    public void setNearest_area(List<NearestArea> nearest_area) {
        this.nearest_area = nearest_area;
    }


    @Override
    public String toString() {
        return "WeatherInfo{" +
                "current_condition=" + current_condition +
                ", nearest_area=" + nearest_area +
                '}';
    }
}