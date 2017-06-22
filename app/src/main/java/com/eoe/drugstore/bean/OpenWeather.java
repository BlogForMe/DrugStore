package com.eoe.drugstore.bean;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */

public class OpenWeather {

    /**
     * cod : 200
     * message : 0.0072
     * cnt : 37
     * list : [{"dt":1498122000,"main":{"temp":296.54,"temp_min":296.54,"temp_max":296.543,"pressure":1002.61,"sea_level":1018.69,"grnd_level":1002.61,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":0.9,"deg":184.003},"rain":{"3h":3.01},"sys":{"pod":"d"},"dt_txt":"2017-06-22 09:00:00"},{"dt":1498132800,"main":{"temp":295.91,"temp_min":295.91,"temp_max":295.912,"pressure":1002.93,"sea_level":1019.2,"grnd_level":1002.93,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":1.27,"deg":54.5033},"rain":{"3h":6.82},"sys":{"pod":"n"},"dt_txt":"2017-06-22 12:00:00"},{"dt":1498143600,"main":{"temp":295.73,"temp_min":295.73,"temp_max":295.73,"pressure":1003.71,"sea_level":1019.92,"grnd_level":1003.71,"humidity":99,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":100},"wind":{"speed":1.06,"deg":318.006},"rain":{"3h":2.69},"sys":{"pod":"n"},"dt_txt":"2017-06-22 15:00:00"},{"dt":1498154400,"main":{"temp":295.45,"temp_min":295.45,"temp_max":295.45,"pressure":1003.52,"sea_level":1019.81,"grnd_level":1003.52,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":1.22,"deg":257.001},"rain":{"3h":0.155},"sys":{"pod":"n"},"dt_txt":"2017-06-22 18:00:00"},{"dt":1498165200,"main":{"temp":295.175,"temp_min":295.175,"temp_max":295.175,"pressure":1003.92,"sea_level":1020.23,"grnd_level":1003.92,"humidity":99,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":80},"wind":{"speed":1.21,"deg":257.008},"rain":{"3h":0.13},"sys":{"pod":"d"},"dt_txt":"2017-06-22 21:00:00"},{"dt":1498176000,"main":{"temp":296.877,"temp_min":296.877,"temp_max":296.877,"pressure":1004.26,"sea_level":1020.5,"grnd_level":1004.26,"humidity":98,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":80},"wind":{"speed":1.72,"deg":165.001},"rain":{"3h":0.029999999999994},"sys":{"pod":"d"},"dt_txt":"2017-06-23 00:00:00"},{"dt":1498186800,"main":{"temp":298.134,"temp_min":298.134,"temp_max":298.134,"pressure":1004.2,"sea_level":1020.24,"grnd_level":1004.2,"humidity":98,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.66,"deg":202.004},"rain":{"3h":3.43},"sys":{"pod":"d"},"dt_txt":"2017-06-23 03:00:00"},{"dt":1498197600,"main":{"temp":296.395,"temp_min":296.395,"temp_max":296.395,"pressure":1002.62,"sea_level":1018.83,"grnd_level":1002.62,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.66,"deg":139.505},"rain":{"3h":10.09},"sys":{"pod":"d"},"dt_txt":"2017-06-23 06:00:00"},{"dt":1498208400,"main":{"temp":295.702,"temp_min":295.702,"temp_max":295.702,"pressure":1001.97,"sea_level":1018.15,"grnd_level":1001.97,"humidity":100,"temp_kf":0},"weather":[{"id":502,"main":"Rain","description":"heavy intensity rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.21,"deg":161.004},"rain":{"3h":14.93},"sys":{"pod":"d"},"dt_txt":"2017-06-23 09:00:00"},{"dt":1498219200,"main":{"temp":295.535,"temp_min":295.535,"temp_max":295.535,"pressure":1000.86,"sea_level":1017.07,"grnd_level":1000.86,"humidity":99,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":1.12,"deg":243.5},"rain":{"3h":0.27},"sys":{"pod":"n"},"dt_txt":"2017-06-23 12:00:00"},{"dt":1498230000,"main":{"temp":295.64,"temp_min":295.64,"temp_max":295.64,"pressure":1001.51,"sea_level":1017.59,"grnd_level":1001.51,"humidity":99,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":0.91,"deg":0},"rain":{"3h":3.77},"sys":{"pod":"n"},"dt_txt":"2017-06-23 15:00:00"},{"dt":1498240800,"main":{"temp":295.51,"temp_min":295.51,"temp_max":295.51,"pressure":1000.07,"sea_level":1016.25,"grnd_level":1000.07,"humidity":99,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":0.84,"deg":55},"rain":{"3h":0.060000000000002},"sys":{"pod":"n"},"dt_txt":"2017-06-23 18:00:00"},{"dt":1498251600,"main":{"temp":295.5,"temp_min":295.5,"temp_max":295.5,"pressure":1000.56,"sea_level":1016.7,"grnd_level":1000.56,"humidity":99,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.15,"deg":19.5028},"rain":{"3h":3.14},"sys":{"pod":"d"},"dt_txt":"2017-06-23 21:00:00"},{"dt":1498262400,"main":{"temp":296.913,"temp_min":296.913,"temp_max":296.913,"pressure":1001.22,"sea_level":1017.48,"grnd_level":1001.22,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.61,"deg":62.001},"rain":{"3h":3.52},"sys":{"pod":"d"},"dt_txt":"2017-06-24 00:00:00"},{"dt":1498273200,"main":{"temp":299.023,"temp_min":299.023,"temp_max":299.023,"pressure":1000.64,"sea_level":1016.76,"grnd_level":1000.64,"humidity":98,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.06,"deg":14.506},"rain":{"3h":0.070000000000007},"sys":{"pod":"d"},"dt_txt":"2017-06-24 03:00:00"},{"dt":1498284000,"main":{"temp":298.439,"temp_min":298.439,"temp_max":298.439,"pressure":998.77,"sea_level":1014.74,"grnd_level":998.77,"humidity":98,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":88},"wind":{"speed":0.86,"deg":197.5},"rain":{"3h":3.79},"sys":{"pod":"d"},"dt_txt":"2017-06-24 06:00:00"},{"dt":1498294800,"main":{"temp":296.788,"temp_min":296.788,"temp_max":296.788,"pressure":998.83,"sea_level":1014.85,"grnd_level":998.83,"humidity":100,"temp_kf":0},"weather":[{"id":502,"main":"Rain","description":"heavy intensity rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":2.01,"deg":288.505},"rain":{"3h":12.53},"sys":{"pod":"d"},"dt_txt":"2017-06-24 09:00:00"},{"dt":1498305600,"main":{"temp":296.372,"temp_min":296.372,"temp_max":296.372,"pressure":999.62,"sea_level":1015.81,"grnd_level":999.62,"humidity":98,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10n"}],"clouds":{"all":76},"wind":{"speed":1.21,"deg":242.004},"rain":{"3h":4.27},"sys":{"pod":"n"},"dt_txt":"2017-06-24 12:00:00"},{"dt":1498316400,"main":{"temp":295.399,"temp_min":295.399,"temp_max":295.399,"pressure":1000.3,"sea_level":1016.66,"grnd_level":1000.3,"humidity":97,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":32},"wind":{"speed":0.61,"deg":7.50485},"rain":{"3h":1.18},"sys":{"pod":"n"},"dt_txt":"2017-06-24 15:00:00"},{"dt":1498327200,"main":{"temp":294.552,"temp_min":294.552,"temp_max":294.552,"pressure":1000.5,"sea_level":1016.64,"grnd_level":1000.5,"humidity":98,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":64},"wind":{"speed":0.92,"deg":299.002},"rain":{"3h":0.010000000000005},"sys":{"pod":"n"},"dt_txt":"2017-06-24 18:00:00"},{"dt":1498338000,"main":{"temp":295.044,"temp_min":295.044,"temp_max":295.044,"pressure":1001.18,"sea_level":1017.36,"grnd_level":1001.18,"humidity":98,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.13,"deg":217.504},"rain":{"3h":0.089999999999989},"sys":{"pod":"d"},"dt_txt":"2017-06-24 21:00:00"},{"dt":1498348800,"main":{"temp":296.773,"temp_min":296.773,"temp_max":296.773,"pressure":1002.92,"sea_level":1019.06,"grnd_level":1002.92,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.61,"deg":291.001},"rain":{"3h":0.21000000000001},"sys":{"pod":"d"},"dt_txt":"2017-06-25 00:00:00"},{"dt":1498359600,"main":{"temp":294.716,"temp_min":294.716,"temp_max":294.716,"pressure":1002.98,"sea_level":1019.21,"grnd_level":1002.98,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.92,"deg":0.500244},"rain":{"3h":2.82},"sys":{"pod":"d"},"dt_txt":"2017-06-25 03:00:00"},{"dt":1498370400,"main":{"temp":293.538,"temp_min":293.538,"temp_max":293.538,"pressure":1002.96,"sea_level":1019.17,"grnd_level":1002.96,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":1.96,"deg":353},"rain":{"3h":6.61},"sys":{"pod":"d"},"dt_txt":"2017-06-25 06:00:00"},{"dt":1498381200,"main":{"temp":293.07,"temp_min":293.07,"temp_max":293.07,"pressure":1002.17,"sea_level":1018.36,"grnd_level":1002.17,"humidity":100,"temp_kf":0},"weather":[{"id":502,"main":"Rain","description":"heavy intensity rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":1.06,"deg":358.501},"rain":{"3h":15.02},"sys":{"pod":"d"},"dt_txt":"2017-06-25 09:00:00"},{"dt":1498392000,"main":{"temp":293.013,"temp_min":293.013,"temp_max":293.013,"pressure":1003.17,"sea_level":1019.45,"grnd_level":1003.17,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":1.21,"deg":249.002},"rain":{"3h":4.21},"sys":{"pod":"n"},"dt_txt":"2017-06-25 12:00:00"},{"dt":1498402800,"main":{"temp":292.943,"temp_min":292.943,"temp_max":292.943,"pressure":1003.47,"sea_level":1019.78,"grnd_level":1003.47,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":1.27,"deg":256.001},"rain":{"3h":0.11000000000001},"sys":{"pod":"n"},"dt_txt":"2017-06-25 15:00:00"},{"dt":1498413600,"main":{"temp":292.765,"temp_min":292.765,"temp_max":292.765,"pressure":1002.83,"sea_level":1019.03,"grnd_level":1002.83,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10n"}],"clouds":{"all":100},"wind":{"speed":1.29,"deg":289.002},"rain":{"3h":5.5},"sys":{"pod":"n"},"dt_txt":"2017-06-25 18:00:00"},{"dt":1498424400,"main":{"temp":292.5,"temp_min":292.5,"temp_max":292.5,"pressure":1003.19,"sea_level":1019.47,"grnd_level":1003.19,"humidity":100,"temp_kf":0},"weather":[{"id":502,"main":"Rain","description":"heavy intensity rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.22,"deg":255.504},"rain":{"3h":13.71},"sys":{"pod":"d"},"dt_txt":"2017-06-25 21:00:00"},{"dt":1498435200,"main":{"temp":293.227,"temp_min":293.227,"temp_max":293.227,"pressure":1004.51,"sea_level":1020.8,"grnd_level":1004.51,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":1.66,"deg":234.504},"rain":{"3h":10.22},"sys":{"pod":"d"},"dt_txt":"2017-06-26 00:00:00"},{"dt":1498446000,"main":{"temp":294.38,"temp_min":294.38,"temp_max":294.38,"pressure":1005.25,"sea_level":1021.52,"grnd_level":1005.25,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.62,"deg":259.5},"rain":{"3h":2},"sys":{"pod":"d"},"dt_txt":"2017-06-26 03:00:00"},{"dt":1498456800,"main":{"temp":297.022,"temp_min":297.022,"temp_max":297.022,"pressure":1004.22,"sea_level":1020.37,"grnd_level":1004.22,"humidity":92,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":88},"wind":{"speed":1.77,"deg":234.009},"rain":{"3h":0.010000000000019},"sys":{"pod":"d"},"dt_txt":"2017-06-26 06:00:00"},{"dt":1498467600,"main":{"temp":297.803,"temp_min":297.803,"temp_max":297.803,"pressure":1003.69,"sea_level":1020,"grnd_level":1003.69,"humidity":88,"temp_kf":0},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"clouds":{"all":76},"wind":{"speed":1.71,"deg":248.002},"rain":{},"sys":{"pod":"d"},"dt_txt":"2017-06-26 09:00:00"},{"dt":1498478400,"main":{"temp":295.669,"temp_min":295.669,"temp_max":295.669,"pressure":1004.52,"sea_level":1020.82,"grnd_level":1004.52,"humidity":95,"temp_kf":0},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04n"}],"clouds":{"all":68},"wind":{"speed":1.12,"deg":214.001},"rain":{},"sys":{"pod":"n"},"dt_txt":"2017-06-26 12:00:00"},{"dt":1498489200,"main":{"temp":294.209,"temp_min":294.209,"temp_max":294.209,"pressure":1005.76,"sea_level":1022.05,"grnd_level":1005.76,"humidity":95,"temp_kf":0},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04n"}],"clouds":{"all":64},"wind":{"speed":1.17,"deg":200.001},"rain":{},"sys":{"pod":"n"},"dt_txt":"2017-06-26 15:00:00"},{"dt":1498500000,"main":{"temp":294.042,"temp_min":294.042,"temp_max":294.042,"pressure":1005.03,"sea_level":1021.32,"grnd_level":1005.03,"humidity":96,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":100},"wind":{"speed":1.16,"deg":207.5},"rain":{"3h":0.019999999999982},"sys":{"pod":"n"},"dt_txt":"2017-06-26 18:00:00"},{"dt":1498510800,"main":{"temp":294.129,"temp_min":294.129,"temp_max":294.129,"pressure":1005.36,"sea_level":1021.61,"grnd_level":1005.36,"humidity":99,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":1.16,"deg":236.501},"rain":{"3h":0.88},"sys":{"pod":"d"},"dt_txt":"2017-06-26 21:00:00"}]
     * city : {"id":1808926,"name":"Hangzhou","coord":{"lat":30.2937,"lon":120.1614},"country":"CN"}
     */

    private String cod;
    private double message;
    private int cnt;
    private CityBean city;
    private List<ListBean> list;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public CityBean getCity() {
        return city;
    }

    public void setCity(CityBean city) {
        this.city = city;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class CityBean {
        /**
         * id : 1808926
         * name : Hangzhou
         * coord : {"lat":30.2937,"lon":120.1614}
         * country : CN
         */

        private int id;
        private String name;
        private CoordBean coord;
        private String country;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public CoordBean getCoord() {
            return coord;
        }

        public void setCoord(CoordBean coord) {
            this.coord = coord;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public static class CoordBean {
            /**
             * lat : 30.2937
             * lon : 120.1614
             */

            private double lat;
            private double lon;

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLon() {
                return lon;
            }

            public void setLon(double lon) {
                this.lon = lon;
            }
        }
    }

    public static class ListBean {
        /**
         * dt : 1498122000
         * main : {"temp":296.54,"temp_min":296.54,"temp_max":296.543,"pressure":1002.61,"sea_level":1018.69,"grnd_level":1002.61,"humidity":100,"temp_kf":0}
         * weather : [{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}]
         * clouds : {"all":92}
         * wind : {"speed":0.9,"deg":184.003}
         * rain : {"3h":3.01}
         * sys : {"pod":"d"}
         * dt_txt : 2017-06-22 09:00:00
         */

        private int dt;
        private MainBean main;
        private CloudsBean clouds;
        private WindBean wind;
        private RainBean rain;
        private SysBean sys;
        private String dt_txt;
        private List<WeatherBean> weather;

        public int getDt() {
            return dt;
        }

        public void setDt(int dt) {
            this.dt = dt;
        }

        public MainBean getMain() {
            return main;
        }

        public void setMain(MainBean main) {
            this.main = main;
        }

        public CloudsBean getClouds() {
            return clouds;
        }

        public void setClouds(CloudsBean clouds) {
            this.clouds = clouds;
        }

        public WindBean getWind() {
            return wind;
        }

        public void setWind(WindBean wind) {
            this.wind = wind;
        }

        public RainBean getRain() {
            return rain;
        }

        public void setRain(RainBean rain) {
            this.rain = rain;
        }

        public SysBean getSys() {
            return sys;
        }

        public void setSys(SysBean sys) {
            this.sys = sys;
        }

        public String getDt_txt() {
            return dt_txt;
        }

        public void setDt_txt(String dt_txt) {
            this.dt_txt = dt_txt;
        }

        public List<WeatherBean> getWeather() {
            return weather;
        }

        public void setWeather(List<WeatherBean> weather) {
            this.weather = weather;
        }

        public static class MainBean {
            /**
             * temp : 296.54
             * temp_min : 296.54
             * temp_max : 296.543
             * pressure : 1002.61
             * sea_level : 1018.69
             * grnd_level : 1002.61
             * humidity : 100
             * temp_kf : 0
             */

            private double temp;
            private double temp_min;
            private double temp_max;
            private double pressure;
            private double sea_level;
            private double grnd_level;
            private int humidity;
            private int temp_kf;

            public double getTemp() {
                return temp;
            }

            public void setTemp(double temp) {
                this.temp = temp;
            }

            public double getTemp_min() {
                return temp_min;
            }

            public void setTemp_min(double temp_min) {
                this.temp_min = temp_min;
            }

            public double getTemp_max() {
                return temp_max;
            }

            public void setTemp_max(double temp_max) {
                this.temp_max = temp_max;
            }

            public double getPressure() {
                return pressure;
            }

            public void setPressure(double pressure) {
                this.pressure = pressure;
            }

            public double getSea_level() {
                return sea_level;
            }

            public void setSea_level(double sea_level) {
                this.sea_level = sea_level;
            }

            public double getGrnd_level() {
                return grnd_level;
            }

            public void setGrnd_level(double grnd_level) {
                this.grnd_level = grnd_level;
            }

            public int getHumidity() {
                return humidity;
            }

            public void setHumidity(int humidity) {
                this.humidity = humidity;
            }

            public int getTemp_kf() {
                return temp_kf;
            }

            public void setTemp_kf(int temp_kf) {
                this.temp_kf = temp_kf;
            }
        }

        public static class CloudsBean {
            /**
             * all : 92
             */

            private int all;

            public int getAll() {
                return all;
            }

            public void setAll(int all) {
                this.all = all;
            }
        }

        public static class WindBean {
            /**
             * speed : 0.9
             * deg : 184.003
             */

            private double speed;
            private double deg;

            public double getSpeed() {
                return speed;
            }

            public void setSpeed(double speed) {
                this.speed = speed;
            }

            public double getDeg() {
                return deg;
            }

            public void setDeg(double deg) {
                this.deg = deg;
            }
        }

        public static class RainBean {
            /**
             * 3h : 3.01
             */

            @SerializedName("3h")
            private double _$3h;

            public double get_$3h() {
                return _$3h;
            }

            public void set_$3h(double _$3h) {
                this._$3h = _$3h;
            }
        }

        public static class SysBean {
            /**
             * pod : d
             */

            private String pod;

            public String getPod() {
                return pod;
            }

            public void setPod(String pod) {
                this.pod = pod;
            }
        }

        public static class WeatherBean {
            /**
             * id : 501
             * main : Rain
             * description : moderate rain
             * icon : 10d
             */

            private int id;
            private String main;
            private String description;
            private String icon;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMain() {
                return main;
            }

            public void setMain(String main) {
                this.main = main;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }
    }
}
