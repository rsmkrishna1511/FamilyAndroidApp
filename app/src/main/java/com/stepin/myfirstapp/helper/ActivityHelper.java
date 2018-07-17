package com.stepin.myfirstapp.helper;

import android.app.Activity;
import android.widget.EditText;
import android.widget.RatingBar;

import com.stepin.myfirstapp.R;
import com.stepin.myfirstapp.model.Family;

public class ActivityHelper {

    private  final Activity activity;

    public ActivityHelper(Activity activity) {
        this.activity = activity;
    }

    public String getName(){
        EditText eTextIns =  activity.findViewById(R.id.editText_Name);
        String  name = eTextIns.getText().toString();
        return  name;
    }

    public String getAddress(){
        EditText eTextIns =  activity.findViewById(R.id.editText_Address);
        String  address = eTextIns.getText().toString();
        return  address;
    }

    public Integer getPnumber(){
        EditText eTextIns =  activity.findViewById(R.id.editText_Phone);
        String  pNumber = eTextIns.getText().toString();
        return  Integer.parseInt(pNumber);
    }

    public String getWebsite(){
        EditText eTextIns = activity.findViewById(R.id.editText_Website);
        String webSite = eTextIns.getText().toString();
        return webSite;
    }

    public String getEmail(){
        EditText eTextIns = activity.findViewById(R.id.editText_eMail);
        String email = eTextIns.getText().toString();
        return email;
    }

    public Double getRating(){
        RatingBar rBar = activity.findViewById(R.id.ratingBar);
        return Double.valueOf(rBar.getRating());
    }

    public Family getFamilyInst() {

        return new Family( getName(),getEmail(),getWebsite(),getPnumber(),getAddress(),getRating());
    }

    public void fillFamilyInfo(Family family) {
       EditText nameInput =  activity.findViewById(R.id.editText_Name);
       nameInput.setText(family.getfName());

        EditText addresInput =  activity.findViewById(R.id.editText_Address);
        addresInput.setText(family.getAddress());

        EditText phInput =  activity.findViewById(R.id.editText_Phone);
        phInput.setText((family.getpNumber() == null ? "" : family.getpNumber().toString()));

        EditText siteInput = activity.findViewById(R.id.editText_Website);
        siteInput.setText(family.getWebsite());

        EditText emailInput = activity.findViewById(R.id.editText_eMail);
        emailInput.setText(family.getEmail());

        RatingBar rBar = activity.findViewById(R.id.ratingBar);
        rBar.setRating(family.getRating().floatValue());
    }
}
