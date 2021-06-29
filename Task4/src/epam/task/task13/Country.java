package epam.task.task13;

import java.util.ArrayList;
import java.util.List;

public class Country {
    private String name;
    private String capital;
    private double area;
    private int count_region;

    public String getName() {
        return name;
    }


    public double getArea() {
        return area;
    }

    public void setArea(Region area) {
        this.area = area.getArea() + getArea();
    }

    private List<City> cityList = new ArrayList<>();
    private List<District> districtList = new ArrayList<>();
    private List<Region> regionList = new ArrayList<>();

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    public void addCity(City city) {
        cityList.add(city);
    }

    public void addDistrict(District district) {
        districtList.add(district);
    }

    public void addRegion(Region region) {
        setArea(region);
        regionList.add(region);
        count_region++;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public List<District> getDistrictList() {
        return districtList;
    }

    public List<Region> getRegionList() {
        return regionList;
    }

    @Override
    public String toString() {
        String country = "";
        country = "Страна - " + name + "\nСтолица - " + capital + "\nКоличество областей - "
                + count_region + "\nПлощадь - " + area + " km2" + "\nОбластные центры - " +  getCityList();
        return country;
    }
}
