
package myset;
  public class SearchResult implements Comparable<SearchResult>{
    float relevance;
    PageEntry pageentry;
    
    public SearchResult(PageEntry p,float r){
            pageentry=p;
            relevance=r;
}
    public PageEntry getPageEntry(){
        return pageentry;
    }
    public float getRelevance(){
        return relevance;
    }
    @Override
    public int compareTo(SearchResult otherObject){
        if(this.relevance>otherObject.relevance)
            return -1;
        else if(this.relevance==otherObject.relevance)
            return 0;
        else return 1;
    }

    
  }