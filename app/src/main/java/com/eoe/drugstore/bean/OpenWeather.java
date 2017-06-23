package com.eoe.drugstore.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jon on 17-6-22.
 */

public class OpenWeather {


    /**
     * cod : 200
     * message : 0.0098
     * cnt : 40
     * list : [{"dt":1498143600,"main":{"temp":296.27,"temp_min":296.27,"temp_max":297.141,"pressure":1003.79,"sea_level":1020.12,"grnd_level":1003.79,"humidity":93,"temp_kf":-0.87},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":64},"wind":{"speed":1.62,"deg":210.001},"rain":{"3h":0.0025},"sys":{"pod":"n"},"dt_txt":"2017-06-22 15:00:00"},{"dt":1498154400,"main":{"temp":295.26,"temp_min":295.26,"temp_max":295.915,"pressure":1003.28,"sea_level":1019.65,"grnd_level":1003.28,"humidity":92,"temp_kf":-0.65},"weather":[{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03n"}],"clouds":{"all":36},"wind":{"speed":1.81,"deg":224.503},"rain":{},"sys":{"pod":"n"},"dt_txt":"2017-06-22 18:00:00"},{"dt":1498165200,"main":{"temp":294.8,"temp_min":294.8,"temp_max":295.235,"pressure":1003.2,"sea_level":1019.5,"grnd_level":1003.2,"humidity":94,"temp_kf":-0.43},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"clouds":{"all":80},"wind":{"speed":1.41,"deg":214.503},"rain":{},"sys":{"pod":"d"},"dt_txt":"2017-06-22 21:00:00"},{"dt":1498176000,"main":{"temp":299.42,"temp_min":299.42,"temp_max":299.638,"pressure":1003.28,"sea_level":1019.63,"grnd_level":1003.28,"humidity":88,"temp_kf":-0.22},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"clouds":{"all":76},"wind":{"speed":1.43,"deg":232.502},"rain":{},"sys":{"pod":"d"},"dt_txt":"2017-06-23 00:00:00"},{"dt":1498186800,"main":{"temp":301.398,"temp_min":301.398,"temp_max":301.398,"pressure":1003.55,"sea_level":1019.84,"grnd_level":1003.55,"humidity":85,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":2.11,"deg":230.504},"rain":{"3h":0.1075},"sys":{"pod":"d"},"dt_txt":"2017-06-23 03:00:00"},{"dt":1498197600,"main":{"temp":300.571,"temp_min":300.571,"temp_max":300.571,"pressure":1002.61,"sea_level":1018.9,"grnd_level":1002.61,"humidity":86,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":2.16,"deg":204.002},"rain":{"3h":0.5575},"sys":{"pod":"d"},"dt_txt":"2017-06-23 06:00:00"},{"dt":1498208400,"main":{"temp":296.922,"temp_min":296.922,"temp_max":296.922,"pressure":1002.94,"sea_level":1019.02,"grnd_level":1002.94,"humidity":97,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.4,"deg":237.501},"rain":{"3h":3.255},"sys":{"pod":"d"},"dt_txt":"2017-06-23 09:00:00"},{"dt":1498219200,"main":{"temp":295.34,"temp_min":295.34,"temp_max":295.34,"pressure":1002.35,"sea_level":1018.58,"grnd_level":1002.35,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":0.86,"deg":87.5006},"rain":{"3h":1.675},"sys":{"pod":"n"},"dt_txt":"2017-06-23 12:00:00"},{"dt":1498230000,"main":{"temp":295.422,"temp_min":295.422,"temp_max":295.422,"pressure":1001.28,"sea_level":1017.38,"grnd_level":1001.28,"humidity":99,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":88},"wind":{"speed":1.17,"deg":192.002},"rain":{"3h":0.05},"sys":{"pod":"n"},"dt_txt":"2017-06-23 15:00:00"},{"dt":1498240800,"main":{"temp":295.451,"temp_min":295.451,"temp_max":295.451,"pressure":1000.11,"sea_level":1016.3,"grnd_level":1000.11,"humidity":99,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":1.16,"deg":211.003},"rain":{"3h":0.06},"sys":{"pod":"n"},"dt_txt":"2017-06-23 18:00:00"},{"dt":1498251600,"main":{"temp":295.368,"temp_min":295.368,"temp_max":295.368,"pressure":998.83,"sea_level":1015.06,"grnd_level":998.83,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.25,"deg":112.004},"rain":{"3h":3.085},"sys":{"pod":"d"},"dt_txt":"2017-06-23 21:00:00"},{"dt":1498262400,"main":{"temp":295.549,"temp_min":295.549,"temp_max":295.549,"pressure":998.78,"sea_level":1014.76,"grnd_level":998.78,"humidity":100,"temp_kf":0},"weather":[{"id":502,"main":"Rain","description":"heavy intensity rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":1.66,"deg":277.501},"rain":{"3h":18.79},"sys":{"pod":"d"},"dt_txt":"2017-06-24 00:00:00"},{"dt":1498273200,"main":{"temp":297.312,"temp_min":297.312,"temp_max":297.312,"pressure":999.18,"sea_level":1015.38,"grnd_level":999.18,"humidity":98,"temp_kf":0},"weather":[{"id":502,"main":"Rain","description":"heavy intensity rain","icon":"10d"}],"clouds":{"all":88},"wind":{"speed":2.67,"deg":241.502},"rain":{"3h":17.655},"sys":{"pod":"d"},"dt_txt":"2017-06-24 03:00:00"},{"dt":1498284000,"main":{"temp":298.135,"temp_min":298.135,"temp_max":298.135,"pressure":999.33,"sea_level":1015.4,"grnd_level":999.33,"humidity":95,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":88},"wind":{"speed":2.66,"deg":233.502},"rain":{"3h":1.335},"sys":{"pod":"d"},"dt_txt":"2017-06-24 06:00:00"},{"dt":1498294800,"main":{"temp":298.62,"temp_min":298.62,"temp_max":298.62,"pressure":999.14,"sea_level":1015.32,"grnd_level":999.14,"humidity":92,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":76},"wind":{"speed":2.37,"deg":237.5},"rain":{"3h":0.52},"sys":{"pod":"d"},"dt_txt":"2017-06-24 09:00:00"},{"dt":1498305600,"main":{"temp":297.388,"temp_min":297.388,"temp_max":297.388,"pressure":1000.66,"sea_level":1016.82,"grnd_level":1000.66,"humidity":94,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":88},"wind":{"speed":1.16,"deg":234.001},"rain":{"3h":0.015000000000001},"sys":{"pod":"n"},"dt_txt":"2017-06-24 12:00:00"},{"dt":1498316400,"main":{"temp":296.321,"temp_min":296.321,"temp_max":296.321,"pressure":1001.35,"sea_level":1017.6,"grnd_level":1001.35,"humidity":97,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":88},"wind":{"speed":1.21,"deg":197.502},"rain":{"3h":0.085000000000001},"sys":{"pod":"n"},"dt_txt":"2017-06-24 15:00:00"},{"dt":1498327200,"main":{"temp":295.294,"temp_min":295.294,"temp_max":295.294,"pressure":1000.9,"sea_level":1017.17,"grnd_level":1000.9,"humidity":98,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":56},"wind":{"speed":1.21,"deg":213},"rain":{"3h":0.0049999999999955},"sys":{"pod":"n"},"dt_txt":"2017-06-24 18:00:00"},{"dt":1498338000,"main":{"temp":295.23,"temp_min":295.23,"temp_max":295.23,"pressure":1001.3,"sea_level":1017.51,"grnd_level":1001.3,"humidity":99,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":1.22,"deg":192.5},"rain":{"3h":1.51},"sys":{"pod":"d"},"dt_txt":"2017-06-24 21:00:00"},{"dt":1498348800,"main":{"temp":295.86,"temp_min":295.86,"temp_max":295.86,"pressure":1002.32,"sea_level":1018.61,"grnd_level":1002.32,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":1.56,"deg":204.503},"rain":{"3h":6.235},"sys":{"pod":"d"},"dt_txt":"2017-06-25 00:00:00"},{"dt":1498359600,"main":{"temp":295.6,"temp_min":295.6,"temp_max":295.6,"pressure":1003.27,"sea_level":1019.5,"grnd_level":1003.27,"humidity":100,"temp_kf":0},"weather":[{"id":502,"main":"Rain","description":"heavy intensity rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":1.66,"deg":39.5018},"rain":{"3h":15.12},"sys":{"pod":"d"},"dt_txt":"2017-06-25 03:00:00"},{"dt":1498370400,"main":{"temp":294.032,"temp_min":294.032,"temp_max":294.032,"pressure":1003.2,"sea_level":1019.27,"grnd_level":1003.2,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.97,"deg":33.0023},"rain":{"3h":9.57},"sys":{"pod":"d"},"dt_txt":"2017-06-25 06:00:00"},{"dt":1498381200,"main":{"temp":293.162,"temp_min":293.162,"temp_max":293.162,"pressure":1002.53,"sea_level":1018.69,"grnd_level":1002.53,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":0.84,"deg":112.502},"rain":{"3h":8.195},"sys":{"pod":"d"},"dt_txt":"2017-06-25 09:00:00"},{"dt":1498392000,"main":{"temp":292.993,"temp_min":292.993,"temp_max":292.993,"pressure":1002.94,"sea_level":1019.26,"grnd_level":1002.94,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10n"}],"clouds":{"all":100},"wind":{"speed":1.45,"deg":171.504},"rain":{"3h":8.185},"sys":{"pod":"n"},"dt_txt":"2017-06-25 12:00:00"},{"dt":1498402800,"main":{"temp":293.042,"temp_min":293.042,"temp_max":293.042,"pressure":1003.67,"sea_level":1019.95,"grnd_level":1003.67,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":1.22,"deg":203},"rain":{"3h":0.23},"sys":{"pod":"n"},"dt_txt":"2017-06-25 15:00:00"},{"dt":1498413600,"main":{"temp":293.135,"temp_min":293.135,"temp_max":293.135,"pressure":1003.36,"sea_level":1019.68,"grnd_level":1003.36,"humidity":100,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"clouds":{"all":92},"wind":{"speed":1.22,"deg":198.507},"rain":{},"sys":{"pod":"n"},"dt_txt":"2017-06-25 18:00:00"},{"dt":1498424400,"main":{"temp":293.188,"temp_min":293.188,"temp_max":293.188,"pressure":1004.06,"sea_level":1020.31,"grnd_level":1004.06,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.22,"deg":195.503},"rain":{"3h":0.44},"sys":{"pod":"d"},"dt_txt":"2017-06-25 21:00:00"},{"dt":1498435200,"main":{"temp":294.768,"temp_min":294.768,"temp_max":294.768,"pressure":1004.93,"sea_level":1021.3,"grnd_level":1004.93,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.72,"deg":213.008},"rain":{"3h":0.23},"sys":{"pod":"d"},"dt_txt":"2017-06-26 00:00:00"},{"dt":1498446000,"main":{"temp":296.573,"temp_min":296.573,"temp_max":296.573,"pressure":1005.57,"sea_level":1021.86,"grnd_level":1005.57,"humidity":94,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.76,"deg":227.5},"rain":{"3h":0.099999999999994},"sys":{"pod":"d"},"dt_txt":"2017-06-26 03:00:00"},{"dt":1498456800,"main":{"temp":296.502,"temp_min":296.502,"temp_max":296.502,"pressure":1005.23,"sea_level":1021.54,"grnd_level":1005.23,"humidity":97,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.96,"deg":216.002},"rain":{"3h":0.81},"sys":{"pod":"d"},"dt_txt":"2017-06-26 06:00:00"},{"dt":1498467600,"main":{"temp":296.625,"temp_min":296.625,"temp_max":296.625,"pressure":1004.49,"sea_level":1020.7,"grnd_level":1004.49,"humidity":90,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":2.11,"deg":213.502},"rain":{"3h":0.010000000000005},"sys":{"pod":"d"},"dt_txt":"2017-06-26 09:00:00"},{"dt":1498478400,"main":{"temp":294.898,"temp_min":294.898,"temp_max":294.898,"pressure":1005.27,"sea_level":1021.65,"grnd_level":1005.27,"humidity":95,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":1.34,"deg":210.002},"rain":{"3h":0.12},"sys":{"pod":"n"},"dt_txt":"2017-06-26 12:00:00"},{"dt":1498489200,"main":{"temp":293.926,"temp_min":293.926,"temp_max":293.926,"pressure":1006.01,"sea_level":1022.44,"grnd_level":1006.01,"humidity":99,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":1.24,"deg":203.501},"rain":{"3h":0.0099999999999909},"sys":{"pod":"n"},"dt_txt":"2017-06-26 15:00:00"},{"dt":1498500000,"main":{"temp":293.658,"temp_min":293.658,"temp_max":293.658,"pressure":1005.53,"sea_level":1021.83,"grnd_level":1005.53,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10n"}],"clouds":{"all":100},"wind":{"speed":1.32,"deg":205.501},"rain":{"3h":3.53},"sys":{"pod":"n"},"dt_txt":"2017-06-26 18:00:00"},{"dt":1498510800,"main":{"temp":293.397,"temp_min":293.397,"temp_max":293.397,"pressure":1005.63,"sea_level":1021.85,"grnd_level":1005.63,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":1.32,"deg":175.008},"rain":{"3h":8.65},"sys":{"pod":"d"},"dt_txt":"2017-06-26 21:00:00"},{"dt":1498521600,"main":{"temp":292.951,"temp_min":292.951,"temp_max":292.951,"pressure":1007.09,"sea_level":1023.36,"grnd_level":1007.09,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.01,"deg":83.0026},"rain":{"3h":7.96},"sys":{"pod":"d"},"dt_txt":"2017-06-27 00:00:00"},{"dt":1498532400,"main":{"temp":293.209,"temp_min":293.209,"temp_max":293.209,"pressure":1007.07,"sea_level":1023.36,"grnd_level":1007.07,"humidity":100,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":0.8,"deg":120.006},"rain":{"3h":5.34},"sys":{"pod":"d"},"dt_txt":"2017-06-27 03:00:00"},{"dt":1498543200,"main":{"temp":294.193,"temp_min":294.193,"temp_max":294.193,"pressure":1006.43,"sea_level":1022.63,"grnd_level":1006.43,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":1.4,"deg":119.001},"rain":{"3h":2.32},"sys":{"pod":"d"},"dt_txt":"2017-06-27 06:00:00"},{"dt":1498554000,"main":{"temp":294.988,"temp_min":294.988,"temp_max":294.988,"pressure":1005.6,"sea_level":1021.82,"grnd_level":1005.6,"humidity":95,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":1.61,"deg":172.002},"rain":{"3h":0.13000000000001},"sys":{"pod":"d"},"dt_txt":"2017-06-27 09:00:00"},{"dt":1498564800,"main":{"temp":293.169,"temp_min":293.169,"temp_max":293.169,"pressure":1005.72,"sea_level":1022.11,"grnd_level":1005.72,"humidity":99,"temp_kf":0},"weather":[{"id":801,"main":"Clouds","description":"few clouds","icon":"02n"}],"clouds":{"all":24},"wind":{"speed":0.96,"deg":352},"rain":{},"sys":{"pod":"n"},"dt_txt":"2017-06-27 12:00:00"}]
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
         * dt : 1498143600
         * main : {"temp":296.27,"temp_min":296.27,"temp_max":297.141,"pressure":1003.79,"sea_level":1020.12,"grnd_level":1003.79,"humidity":93,"temp_kf":-0.87}
         * weather : [{"id":500,"main":"Rain","description":"light rain","icon":"10n"}]
         * clouds : {"all":64}
         * wind : {"speed":1.62,"deg":210.001}
         * rain : {"3h":0.0025}
         * sys : {"pod":"n"}
         * dt_txt : 2017-06-22 15:00:00
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
             * temp : 296.27
             * temp_min : 296.27
             * temp_max : 297.141
             * pressure : 1003.79
             * sea_level : 1020.12
             * grnd_level : 1003.79
             * humidity : 93
             * temp_kf : -0.87
             */

            private double temp;
            private double temp_min;
            private double temp_max;
            private double pressure;
            private double sea_level;
            private double grnd_level;
            private int humidity;
            private double temp_kf;

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

            public double getTemp_kf() {
                return temp_kf;
            }

            public void setTemp_kf(double temp_kf) {
                this.temp_kf = temp_kf;
            }
        }

        public static class CloudsBean {
            /**
             * all : 64
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
             * speed : 1.62
             * deg : 210.001
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
             * 3h : 0.0025
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
             * pod : n
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
             * id : 500
             * main : Rain
             * description : light rain
             * icon : 10n
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
