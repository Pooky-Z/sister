package com.example.a13218.muzic;

public class Sister {
    private String _id;
    private String createdAt;
    private String desc;
    private String publishAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;

    public void set_id(String _id){
        this._id=_id;
    }
    public void setCreatedAt(String createdAt){
        this.createdAt=createdAt;
    }
    public void setDesc(String desc){
        this.desc=desc;
    }
    public void setPublishAt(String publishAt){
        this.publishAt=publishAt;
    }

    public void setSource(String source){
        this.source=source;
    }
    public void setType(String type){
        this.type=type;
    }
    public void setUrl(String url){
        this.url=url;
    }
    public void setUsed(boolean used){
        this.used=used;
    }
    public void setWho(String who){
        this.who=who;
    }
    public String getUrl(){
        return this.url;
    }
}
