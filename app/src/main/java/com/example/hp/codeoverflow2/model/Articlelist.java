package com.example.hp.codeoverflow2.model;

/**
 * Created by Bansal on 10/1/2017.
 */

public class Articlelist {

    public String Article_Name;
    public String JS_File;
  public Articlelist(String a){
      this.Article_Name=a;

  }
    public String getSurvey_Name() {
        return Article_Name;
    }

    public void setSurvey_Name(String survey_Name) {
        Article_Name = survey_Name;
    }
}
