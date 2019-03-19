package xjhxjhxjhxjh.com.github.domain;

import java.util.List;

public class Page<T> {
    
    // 页面展示的内容
    List<T> list;
    // 每页显示的条数
    private int pageSize;
    // 当前页
    private int pageNumber;
    // 总条数
    private int pageSumSize;
    // 总页数
    private int pageSumNumber;
    
    public Page() {}
    
    public Page(int pageSize, int pageNumber) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    public void setPageSumSize(int pageSumSize) {
        this.pageSumSize = pageSumSize;
    }
    public int getPageSumNumber() {
        return pageSumNumber;
    }
    public void setPageSumNumber(int pageSumNumber) {
        this.pageSumNumber = pageSumNumber;
    }
    
    public int getPageSumSize() {
        return (int)Math.ceil(pageSumNumber*1.0/pageSize);
    }
    
    //获取数据索引
    public int getIndex(){
        return (pageNumber-1)*pageSize;
    }
    
}
