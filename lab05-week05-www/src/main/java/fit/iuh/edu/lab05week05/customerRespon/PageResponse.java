package fit.iuh.edu.lab05week05.customerRespon;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageResponse<T>{
    private int status;
    private Page<T> data;
    private int pageNumber;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Page<T> getData() {
        return data;
    }

    public void setData(Page<T> data) {
        this.data = data;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
