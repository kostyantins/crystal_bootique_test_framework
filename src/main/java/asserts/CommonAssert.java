package asserts;

import org.testng.Assert;

public final class CommonAssert {

    protected boolean actual;

    CommonAssert(final Boolean actual) {
        this.actual = actual;
    }

    public static final CommonAssert assertThat(final Boolean actual) {
        return new CommonAssert(actual);
    }

    public final CommonAssert isTrue() {

        if (!actual) {

            Assert.fail("Expected True, but in fact False!");
        }

        return this;
    }
}
