package com.example.vehicelsweb.DbPOJOs;

import com.example.vehicelsweb.StringField;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

import static com.example.vehicelsweb.DbPOJOs.DbUtils.MODEL_FIELDS;

public class Model implements DbPojo{
    @Id
    private int carmodelid;
    private int modelfueltype;
    private int typeofvehicle;
    private int manufacturelocation;
    private int carmake;
    private String modelname;
    private boolean stillproduced;
    private int numberofcylinders;
    private int enginesize;
    private int numberofdoors;
    private boolean iselectric;

    private final List<StringField> fields = new ArrayList<>();
    private final StringField[] values = new StringField[MODEL_FIELDS.length];

    public Model(int carmodelid, int modelfueltype, int typeofvehicle, int manufacturelocation, int carmake,
                 String modelname, boolean stillproduced, int numberofcylinders, int enginesize, int numberofdoors, boolean iselectric) {
        this.carmodelid = carmodelid;
        this.modelfueltype = modelfueltype;
        this.typeofvehicle = typeofvehicle;
        this.manufacturelocation = manufacturelocation;
        this.carmake = carmake;
        this.modelname = modelname;
        this.stillproduced = stillproduced;
        this.numberofcylinders = numberofcylinders;
        this.enginesize = enginesize;
        this.numberofdoors = numberofdoors;
        this.iselectric = iselectric;

        for (String field : MODEL_FIELDS) {
            fields.add(new StringField(field));
        }
    }

    public Model() {
        for (String field : MODEL_FIELDS) {
            fields.add(new StringField(field));
        }
    }

    public int getCarmodelid() {
        return carmodelid;
    }

    public void setCarmodelid(int carmodelid) {
        this.carmodelid = carmodelid;
        values[0] = new StringField("" + carmodelid);
    }

    public int getModelfueltype() {
        return modelfueltype;
    }

    public void setModelfueltype(int modelfueltype) {
        this.modelfueltype = modelfueltype;
        values[1] = new StringField("" + modelfueltype);
    }

    public int getTypeofvehicle() {
        return typeofvehicle;
    }

    public void setTypeofvehicle(int typeofvehicle) {
        this.typeofvehicle = typeofvehicle;
        values[2] = new StringField("" + typeofvehicle);
    }

    public int getManufacturelocation() {
        return manufacturelocation;
    }

    public void setManufacturelocation(int manufacturelocation) {
        this.manufacturelocation = manufacturelocation;
        values[3] = new StringField("" + manufacturelocation);
    }

    public int getCarmake() {
        return carmake;
    }

    public void setCarmake(int carmake) {
        this.carmake = carmake;
        values[4] = new StringField("" + carmake);
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
        values[5] = new StringField(modelname);
    }

    public boolean isStillproduced() {
        return stillproduced;
    }

    public void setStillproduced(boolean stillproduced) {
        this.stillproduced = stillproduced;
        values[6] = new StringField("" + stillproduced);
    }

    public int getNumberofcylinders() {
        return numberofcylinders;
    }

    public void setNumberofcylinders(int numberofcylinders) {
        this.numberofcylinders = numberofcylinders;
        values[7] = new StringField("" + numberofcylinders);
    }

    public int getEnginesize() {
        return enginesize;
    }

    public void setEnginesize(int enginesize) {
        this.enginesize = enginesize;
        values[8] = new StringField("" + enginesize);
    }

    public int getNumberofdoors() {
        return numberofdoors;
    }

    public void setNumberofdoors(int numberofdoors) {
        this.numberofdoors = numberofdoors;
        values[9] = new StringField("" + numberofdoors);
    }

    public boolean isIselectric() {
        return iselectric;
    }

    public void setIselectric(boolean iselectric) {
        this.iselectric = iselectric;
        values[10] = new StringField("" + iselectric);
    }

    @Override
    public List<StringField> getFields() {
        return fields;
    }

    @Override
    public List<StringField> getValues() {
        return List.of(values);
    }
}
