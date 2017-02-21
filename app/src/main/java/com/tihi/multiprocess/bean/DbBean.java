package com.tihi.multiprocess.bean;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;
import com.lidroid.xutils.db.annotation.Transient;
import com.tihi.multiprocess.Util.FastJson;

/**
 * description:
 * author: duantianhui
 * date: 2017/2/21 10:56
 */

@Table(name = "DB_TABLE")
public class DbBean {

    @Id(column = "ID")
    private int id;

    @Column(column = "person_json")
    private String personJson;

    @Transient
    private Person person;

    public DbBean() {}

    public DbBean(Person person) {
        this.person = person;
        personJson = FastJson.toJSONString(person);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonJson() {
        return personJson;
    }

    public void setPersonJson(String personJson) {
        this.personJson = personJson;
        this.person = FastJson.parseObject(personJson, Person.class);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
