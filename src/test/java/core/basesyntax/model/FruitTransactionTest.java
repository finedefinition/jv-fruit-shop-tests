package core.basesyntax.model;

import static core.basesyntax.model.FruitTransaction.Operation.BALANCE;
import static org.junit.Assert.assertEquals;

import core.basesyntax.model.FruitTransaction.Operation;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitTransactionTest {

    private static String TEST_FRUIT = "apple";
    private static String TEST_OPERATION_CODE = "b";
    private static String TEST_WRONG_OPERATION_CODE = "w";
    private static int TEST_BALANCE = 50;
    private static Operation TEST_OPERATION = BALANCE;
    private static FruitTransaction fruitTransaction;

    @BeforeClass
    public static void beforeAll() {
        fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(TEST_OPERATION);
        fruitTransaction.setFruit(TEST_FRUIT);
        fruitTransaction.setQuantity(TEST_BALANCE);
    }

    @Test
    public void getOperation_Work_Ok() {
        Operation actual = fruitTransaction.getOperation();
        Operation expected = TEST_OPERATION;
        assertEquals(expected, actual);
    }

    @Test
    public void getByCode_Work_Ok() {
        Operation actual = Operation.getByCode(TEST_OPERATION_CODE);
        Operation expected = TEST_OPERATION;
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByCode_IllegalArgExc_notOk() {
        fruitTransaction.setOperation(FruitTransaction
                .Operation.getByCode(TEST_WRONG_OPERATION_CODE));
    }

    @Test
    public void getOperationCode_ok() {
        String actual = fruitTransaction.getOperation().getOperation();
        assertEquals(TEST_OPERATION_CODE, actual);
    }
}
