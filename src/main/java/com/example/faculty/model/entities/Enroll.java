package com.example.faculty.model.entities;

import java.util.Date;

public class Enroll {

    public Long enrollId;

    public long created = new Date().getTime();

    public Long idUser;

    public Long idCourse;

    public Long getEnrollId() {
        return enrollId;
    }

    public long getCreated() {
        return created;
    }

    public Long getIdUser() {
        return idUser;
    }

    public Long getIdCourse() {
        return idCourse;
    }


    public class Builder {

        public Enroll.Builder setIdUser(Long idUser) {
            Enroll.this.idUser = idUser;
            return this;
        }

        public Enroll.Builder setIdCourse(Long idCourse) {
            Enroll.this.idCourse = idCourse;
            return this;
        }

        public Enroll build() {
            return Enroll.this;
        }

    }

}
