package ru.kpfu.itis.models;

public class Auth {
    private Long id;
    private Long user;
    private String cookieValue;

    public Auth(Long id, Long user, String cookieValue) {
        this.id = id;
        this.user = user;
        this.cookieValue = cookieValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getCookieValue() {
        return cookieValue;
    }

    public void setCookieValue(String cookieValue) {
        this.cookieValue = cookieValue;
    }
}
