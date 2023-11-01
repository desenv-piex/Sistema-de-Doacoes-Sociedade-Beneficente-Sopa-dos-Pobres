package org.sdp;


import org.sdp.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.close();
    }
}