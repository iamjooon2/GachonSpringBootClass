package com.board.domain;

import java.time.LocalDateTime;

public class UserDTO {

    private Long idx;
    private String username;
    private String password;
    private String adminYn;
    private String secretYn;
    private String deleteYn;
    private LocalDateTime insertTime;
    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "UserDTO [idx=" + idx + ", username=" + username + ", password=" + password + ", adminYn=" + adminYn
                + ", secretYn=" + secretYn + ", deleteYn=" + deleteYn + ", insertTime=" + insertTime + ", updateTime=" + updateTime + "]";
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminYn() {
        return adminYn;
    }

    public void setAdminYn(String adminYn) {
        this.adminYn = adminYn;
    }

    public String getSecretYn() {
        return secretYn;
    }

    public void setSecretYn(String secretYn) {
        this.secretYn = secretYn;
    }

    public String getDeleteYn() {
        return deleteYn;
    }

    public void setDeleteYn(String deleteYn) {
        this.deleteYn = deleteYn;
    }

    public LocalDateTime getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(LocalDateTime insertTime) {
        this.insertTime = insertTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
