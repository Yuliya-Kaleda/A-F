package nyc.c4q.yuliyakaleda.af;

import java.util.List;

public class RetrofitResponse {
    List<Promotion> promotions;

    public RetrofitResponse(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setItems(List<Promotion> promotions) {
        this.promotions = promotions;
    }
}

