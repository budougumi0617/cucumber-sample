package kirimaru.biz.domain;

import org.junit.jupiter.api.Test;

class SwitchTests {
    private int point = 0;

    @Test
    void test_01() {
        switch (point) {
            case 0:
                this.point = 15;
            case 15:
                this.point = 30;
            case 30:
                this.point = 40;
            default:
        }
    }
}
