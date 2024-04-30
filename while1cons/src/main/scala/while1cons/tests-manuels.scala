package while1cons

import while1cons.While1cons._
import while1cons.NewVar._

object TestsManuels extends App {

  def assertEquals(a: Any, b: Any): Boolean = a == b

  def assertNotEquals(a: Any, b: Any): Boolean = a != b

  def assertTrue(a: Boolean): Boolean = a

  // Tests pour les expressions

  def Test_while1ConsExprV_Nil(): Boolean = {
    NewVar.reset();
    assertEquals((List(Set(Var("A0"), Nl)), Var("A0")), while1ConsExprV(Nl))
  }
  println("Test_while1ConsExprV_Nil : " + Test_while1ConsExprV_Nil())

  def Test_while1ConsExprV_Cst(): Boolean = {
    NewVar.reset();
    assertEquals(
      (List(Set(Var("A0"), Cst("aaa"))), Var("A0")),
      while1ConsExprV(Cst("aaa"))
    )
  }
  println("Test_while1ConsExprV_Cst : " + Test_while1ConsExprV_Cst())

  def Test_while1ConsExprV_VarExp(): Boolean = {
    NewVar.reset();
    assertEquals((Nil, Var("X")), while1ConsExprV(VarExp("X")))
  }
  println("Test_while1ConsExprV_VarExp : " + Test_while1ConsExprV_VarExp())

  def Test_while1ConsExprV_Cons1(): Boolean = {
    NewVar.reset();
    assertEquals(
      (
        List(
          Set(Var("A0"), Nl),
          Set(Var("A1"), Nl),
          Set(Var("A2"), Cons(VarExp("A0"), VarExp("A1")))
        ),
        Var("A2")
      ),
      while1ConsExprV(Cons(Nl, Nl))
    )
  }
  println("Test_while1ConsExprV_Cons1 : " + Test_while1ConsExprV_Cons1())

  def Test_while1ConsExprV_Cons2(): Boolean = {
    NewVar.reset();
    assertEquals(
      (List(Set(Var("A0"), Cons(VarExp("X"), VarExp("Y")))), Var("A0")),
      while1ConsExprV(Cons(VarExp("X"), VarExp("Y")))
    )
  }
  println("Test_while1ConsExprV_Cons2 : " + Test_while1ConsExprV_Cons2())

  def Test_while1ConsExprV_Hd(): Boolean = {
    NewVar.reset();
    assertEquals(
      (List(Set(Var("A0"), Hd(VarExp("X")))), Var("A0")),
      while1ConsExprV(Hd(VarExp("X")))
    )
  }
  println("Test_while1ConsExprV_Cons2 : " + Test_while1ConsExprV_Cons2())

  def Test_while1ConsExprV_Tl(): Boolean = {
    NewVar.reset();
    assertEquals(
      (List(Set(Var("A0"), Tl(VarExp("X")))), Var("A0")),
      while1ConsExprV(Tl(VarExp("X")))
    )
  }
  println("Test_while1ConsExprV_Tl : " + Test_while1ConsExprV_Tl())

  def Test_while1ConsExprV_Eq1(): Boolean = {
    NewVar.reset();
    assertEquals(
      (
        List(
          Set(Var("A0"), Nl),
          Set(Var("A1"), Nl),
          Set(Var("A2"), Eq(VarExp("A0"), VarExp("A1")))
        ),
        Var("A2")
      ),
      while1ConsExprV(Eq(Nl, Nl))
    )
  }
  println("Test_while1ConsExprV_Eq1 : " + Test_while1ConsExprV_Eq1())

  def Test_while1ConsExprV_Eq2(): Boolean = {
    NewVar.reset();
    assertEquals(
      (List(Set(Var("A0"), Eq(VarExp("X"), VarExp("Y")))), Var("A0")),
      while1ConsExprV(Eq(VarExp("X"), VarExp("Y")))
    )
  }
  println("Test_while1ConsExprV_Eq2 : " + Test_while1ConsExprV_Eq2())

  def Test_while1ConsExprV_Expr1(): Boolean = {
    NewVar.reset();
    assertEquals(
      (
        List(
          Set(Var("A0"), Nl),
          Set(Var("A1"), Hd(VarExp("A0"))),
          Set(Var("A2"), Tl(VarExp("A1"))),
          Set(Var("A3"), Hd(VarExp("A2")))
        ),
        Var("A3")
      ),
      while1ConsExprV(Hd(Tl(Hd(Nl))))
    )
  }
  println("Test_while1ConsExprV_Expr1 : " + Test_while1ConsExprV_Expr1())

  def Test_while1ConsExprV_Expr2(): Boolean = {
    NewVar.reset();
    assertEquals(
      (
        List(
          Set(Var("A0"), Tl(VarExp("Y"))),
          Set(Var("A1"), Hd(VarExp("X"))),
          Set(Var("A2"), Cons(VarExp("A0"), VarExp("A1")))
        ),
        Var("A2")
      ),
      while1ConsExprV(Cons(Tl(VarExp("Y")), Hd(VarExp("X"))))
    )
  }
  println("Test_while1ConsExprV_Expr2 : " + Test_while1ConsExprV_Expr2())

  def Test_while1ConsExprV_Expr3(): Boolean = {
    NewVar.reset();
    assertEquals(
      (
        List(
          Set(Var("A0"), Tl(VarExp("Y"))),
          Set(Var("A1"), Hd(VarExp("X"))),
          Set(Var("A2"), Cons(VarExp("A0"), VarExp("A1"))),
          Set(Var("A3"), Nl),
          Set(Var("A4"), Hd(VarExp("A3"))),
          Set(Var("A5"), Tl(VarExp("A4"))),
          Set(Var("A6"), Hd(VarExp("A5"))),
          Set(Var("A7"), Eq(VarExp("A2"), VarExp("A6")))
        ),
        Var("A7")
      ),
      while1ConsExprV(
        Eq(Cons(Tl(VarExp("Y")), Hd(VarExp("X"))), Hd(Tl(Hd(Nl))))
      )
    )
  }
  println("Test_while1ConsExprV_Expr3 : " + Test_while1ConsExprV_Expr3())

  def Test_while1ConsExprSE_Nil(): Boolean = {
    NewVar.reset();
    assertEquals((Nil, Nl), while1ConsExprSE(Nl))
  }
  println("Test_while1ConsExprSE_Nil : " + Test_while1ConsExprSE_Nil())

  def Test_while1ConsExprSE_Cst(): Boolean = {
    NewVar.reset();
    assertEquals((Nil, Cst("aaa")), while1ConsExprSE(Cst("aaa")))
  }
  println("Test_while1ConsExprSE_Cst : " + Test_while1ConsExprSE_Cst())

  def Test_while1ConsExprSE_VarExp(): Boolean = {
    NewVar.reset();
    assertEquals((Nil, VarExp("X")), while1ConsExprSE(VarExp("X")))
  }
  println("Test_while1ConsExprSE_Cst : " + Test_while1ConsExprSE_Cst())

  def Test_while1ConsExprSE_Cons1(): Boolean = {
    NewVar.reset();
    assertEquals(
      (
        List(Set(Var("A0"), Nl), Set(Var("A1"), Nl)),
        Cons(VarExp("A0"), VarExp("A1"))
      ),
      while1ConsExprSE(Cons(Nl, Nl))
    )
  }
  println("Test_while1ConsExprSE_Cons1 : " + Test_while1ConsExprSE_Cons1())

  def Test_while1ConsExprSE_Cons2(): Boolean = {
    NewVar.reset();
    assertEquals(
      (Nil, Cons(VarExp("X"), VarExp("Y"))),
      while1ConsExprSE(Cons(VarExp("X"), VarExp("Y")))
    )
  }
  println("Test_while1ConsExprSE_Cons2 : " + Test_while1ConsExprSE_Cons2())

  def Test_while1ConsExprSE_Hd(): Boolean = {
    NewVar.reset();
    assertEquals((Nil, Hd(VarExp("X"))), while1ConsExprSE(Hd(VarExp("X"))))
  }
  println("Test_while1ConsExprSE_Hd : " + Test_while1ConsExprSE_Hd())

  def Test_while1ConsExprSE_Tl(): Boolean = {
    NewVar.reset();
    assertEquals((Nil, Tl(VarExp("X"))), while1ConsExprSE(Tl(VarExp("X"))))
  }
  println("Test_while1ConsExprSE_Tl : " + Test_while1ConsExprSE_Tl())

  def Test_while1ConsExprSE_Eq1(): Boolean = {
    NewVar.reset();
    assertEquals(
      (
        List(Set(Var("A0"), Nl), Set(Var("A1"), Nl)),
        Eq(VarExp("A0"), VarExp("A1"))
      ),
      while1ConsExprSE(Eq(Nl, Nl))
    )
  }
  println("Test_while1ConsExprSE_Eq1 : " + Test_while1ConsExprSE_Eq1())

  def Test_while1ConsExprSE_Eq2(): Boolean = {
    NewVar.reset();
    assertEquals(
      (Nil, Eq(VarExp("X"), VarExp("Y"))),
      while1ConsExprSE(Eq(VarExp("X"), VarExp("Y")))
    )
  }
  println("Test_while1ConsExprSE_Eq2 : " + Test_while1ConsExprSE_Eq2())

  def Test_while1ConsExprSE_Expr1(): Boolean = {
    NewVar.reset();
    assertEquals(
      (
        List(
          Set(Var("A0"), Nl),
          Set(Var("A1"), Hd(VarExp("A0"))),
          Set(Var("A2"), Tl(VarExp("A1")))
        ),
        Hd(VarExp("A2"))
      ),
      while1ConsExprSE(Hd(Tl(Hd(Nl))))
    )
  }
  println("Test_while1ConsExprSE_Expr1 : " + Test_while1ConsExprSE_Expr1())

  def Test_while1ConsExprSE_Expr2(): Boolean = {
    NewVar.reset();
    assertEquals(
      (
        List(Set(Var("A0"), Tl(VarExp("Y"))), Set(Var("A1"), Hd(VarExp("X")))),
        Cons(VarExp("A0"), VarExp("A1"))
      ),
      while1ConsExprSE(Cons(Tl(VarExp("Y")), Hd(VarExp("X"))))
    )
  }
  println("Test_while1ConsExprSE_Expr2 : " + Test_while1ConsExprSE_Expr2())

  def Test_while1ConsExprSE_Expr3(): Boolean = {
    NewVar.reset();
    assertEquals(
      (
        List(
          Set(Var("A0"), Tl(VarExp("Y"))),
          Set(Var("A1"), Hd(VarExp("X"))),
          Set(Var("A2"), Cons(VarExp("A0"), VarExp("A1"))),
          Set(Var("A3"), Nl),
          Set(Var("A4"), Hd(VarExp("A3"))),
          Set(Var("A5"), Tl(VarExp("A4"))),
          Set(Var("A6"), Hd(VarExp("A5")))
        ),
        Eq(VarExp("A2"), VarExp("A6"))
      ),
      while1ConsExprSE(
        Eq(Cons(Tl(VarExp("Y")), Hd(VarExp("X"))), Hd(Tl(Hd(Nl))))
      )
    )
  }
  println("Test_while1ConsExprSE_Expr3 : " + Test_while1ConsExprSE_Expr3())

// Tests pour les commandes

  def Test_while1ConsNop(): Boolean = {
    NewVar.reset();
    assertEquals(List(Nop), while1ConsCommand(Nop))
  }
  println("Test_while1ConsNop : " + Test_while1ConsNop())

  def Test_while1ConsSet_1(): Boolean = {
    NewVar.reset();
    assertEquals(List(Set(Var("X"), Nl)), while1ConsCommand(Set(Var("X"), Nl)))
  }
  println("Test_while1ConsSet_1 : " + Test_while1ConsSet_1())

  def Test_while1ConsSet_2(): Boolean = {
    NewVar.reset();
    assertEquals(
      List(Set(Var("X"), VarExp("Y"))),
      while1ConsCommand(Set(Var("X"), VarExp("Y")))
    )
  }
  println("Test_while1ConsSet_2 : " + Test_while1ConsSet_2())

  def Test_while1ConsSet_3(): Boolean = {
    NewVar.reset();
    assertEquals(
      List(
        Set(Var("A0"), Tl(VarExp("Y"))),
        Set(Var("A1"), Hd(VarExp("X"))),
        Set(Var("X"), Cons(VarExp("A0"), VarExp("A1")))
      ),
      while1ConsCommand(Set(Var("X"), Cons(Tl(VarExp("Y")), Hd(VarExp("X")))))
    )
  }
  println("Test_while1ConsSet_3 : " + Test_while1ConsSet_3())

  def Test_while1ConsCommands_Nop(): Boolean = {
    NewVar.reset();
    assertEquals(List(Nop), while1ConsCommands(List(Nop)))
  }
  println("Test_while1ConsCommands_Nop : " + Test_while1ConsCommands_Nop())

  def Test_while1ConsCommands_NopNop(): Boolean = {
    NewVar.reset();
    assertEquals(List(Nop, Nop), while1ConsCommands(List(Nop, Nop)))
  }
  println(
    "Test_while1ConsCommands_NopNop : " + Test_while1ConsCommands_NopNop()
  )

  def Test_while1ConsCommands_SetSet_1(): Boolean = {
    NewVar.reset();
    assertEquals(
      List(
        Set(Var("A0"), Tl(VarExp("Y"))),
        Set(Var("A1"), Hd(VarExp("X"))),
        Set(Var("X"), Cons(VarExp("A0"), VarExp("A1"))),
        Set(Var("X"), VarExp("Y"))
      ),
      while1ConsCommands(
        List(
          Set(Var("X"), Cons(Tl(VarExp("Y")), Hd(VarExp("X")))),
          Set(Var("X"), VarExp("Y"))
        )
      )
    )
  }
  println(
    "Test_while1ConsCommands_SetSet_1 : " + Test_while1ConsCommands_SetSet_1()
  )

  def Test_while1ConsCommands_SetSet_2(): Boolean = {
    NewVar.reset();
    assertEquals(
      List(
        Set(Var("A0"), Tl(VarExp("Y"))),
        Set(Var("A1"), Hd(VarExp("X"))),
        Set(Var("X"), Cons(VarExp("A0"), VarExp("A1"))),
        Set(Var("A2"), Tl(VarExp("Y"))),
        Set(Var("A3"), Hd(VarExp("X"))),
        Set(Var("X"), Cons(VarExp("A2"), VarExp("A3")))
      ),
      while1ConsCommands(
        List(
          Set(Var("X"), Cons(Tl(VarExp("Y")), Hd(VarExp("X")))),
          Set(Var("X"), Cons(Tl(VarExp("Y")), Hd(VarExp("X"))))
        )
      )
    )
  }
  println(
    "Test_while1ConsCommands_SetSet_2 : " + Test_while1ConsCommands_SetSet_2()
  )

  def Test_while1ConsCommands_SetSet_3(): Boolean = {
    NewVar.reset();
    assertEquals(
      List(
        Set(Var("Z"), Nl),
        Set(Var("A0"), Tl(VarExp("Y"))),
        Set(Var("A1"), Hd(VarExp("X"))),
        Set(Var("X"), Cons(VarExp("A0"), VarExp("A1"))),
        Set(Var("X"), VarExp("Y"))
      ),
      while1ConsCommands(
        List(
          Set(Var("Z"), Nl),
          Set(Var("X"), Cons(Tl(VarExp("Y")), Hd(VarExp("X")))),
          Set(Var("X"), VarExp("Y"))
        )
      )
    )
  }
  println(
    "Test_while1ConsCommands_SetSet_3 : " + Test_while1ConsCommands_SetSet_3()
  )

  def Test_while1ConsWhile_1(): Boolean = {
    NewVar.reset();
    assertEquals(
      List(
        Set(Var("A0"), Tl(VarExp("Y"))),
        Set(Var("A1"), Eq(VarExp("X"), VarExp("A0"))),
        While(
          VarExp("A1"),
          List(
            Set(Var("X"), Cons(VarExp("X"), VarExp("Y"))),
            Set(Var("A2"), Tl(VarExp("Y"))),
            Set(Var("A3"), Hd(VarExp("X"))),
            Set(Var("X"), Cons(VarExp("A2"), VarExp("A3"))),
            Set(Var("A0"), Tl(VarExp("Y"))),
            Set(Var("A1"), Eq(VarExp("X"), VarExp("A0")))
          )
        )
      ),
      while1ConsCommand(
        While(
          Eq(VarExp("X"), Tl(VarExp("Y"))),
          List(
            Set(Var("X"), Cons(VarExp("X"), VarExp("Y"))),
            Set(Var("X"), Cons(Tl(VarExp("Y")), Hd(VarExp("X"))))
          )
        )
      )
    )
  }
  println("Test_while1ConsWhile_1 : " + Test_while1ConsWhile_1())

  def Test_while1ConsWhile_2(): Boolean = {
    NewVar.reset();
    assertEquals(
      List(
        While(
          VarExp("X"),
          List(
            Set(Var("A0"), Hd(VarExp("X"))),
            Set(Var("Y"), Cons(VarExp("A0"), VarExp("Y"))),
            Set(Var("X"), Tl(VarExp("X")))
          )
        )
      ),
      while1ConsCommand(
        While(
          VarExp("X"),
          List(
            Set(Var("Y"), Cons(Hd(VarExp("X")), VarExp("Y"))),
            Set(Var("X"), Tl(VarExp("X")))
          )
        )
      )
    )
  }
  println("Test_while1ConsWhile_2 : " + Test_while1ConsWhile_2())

  def Test_while1ConsFor_1(): Boolean = {
    NewVar.reset();
    assertEquals(
      List(
        Set(Var("A0"), Nl),
        Set(Var("A1"), Nl),
        Set(Var("A2"), Nl),
        Set(Var("A3"), Nl),
        Set(Var("A4"), Cons(VarExp("A2"), VarExp("A3"))),
        Set(Var("A5"), Cons(VarExp("A1"), VarExp("A4"))),
        Set(Var("A6"), Cons(VarExp("A0"), VarExp("A5"))),
        For(
          VarExp("A6"),
          List(
            Set(Var("A7"), Nl),
            Set(Var("X"), Cons(VarExp("A7"), VarExp("X"))),
            Set(Var("Y"), Cons(VarExp("X"), VarExp("X")))
          )
        )
      ),
      while1ConsCommand(
        For(
          Cons(Nl, Cons(Nl, Cons(Nl, Nl))),
          List(
            Set(Var("X"), Cons(Nl, VarExp("X"))),
            Set(Var("Y"), Cons(VarExp("X"), VarExp("X")))
          )
        )
      )
    )
  }
  println("Test_while1ConsFor_1 : " + Test_while1ConsFor_1())

  def Test_while1ConsFor_2(): Boolean = {
    NewVar.reset();
    assertEquals(
      List(
        For(
          VarExp("X"),
          List(
            Set(Var("A0"), Nl),
            Set(Var("X"), Cons(VarExp("A0"), VarExp("X"))),
            Set(Var("Y"), Cons(VarExp("X"), VarExp("X")))
          )
        )
      ),
      while1ConsCommand(
        For(
          VarExp("X"),
          List(
            Set(Var("X"), Cons(Nl, VarExp("X"))),
            Set(Var("Y"), Cons(VarExp("X"), VarExp("X")))
          )
        )
      )
    )
  }
  println("Test_while1ConsFor_2 : " + Test_while1ConsFor_2())

  def Test_while1ConsIf_1(): Boolean = {
    NewVar.reset();
    assertEquals(
      List(
        Set(Var("A0"), Nl),
        Set(Var("A1"), Nl),
        Set(Var("A2"), Nl),
        Set(Var("A3"), Nl),
        Set(Var("A4"), Cons(VarExp("A2"), VarExp("A3"))),
        Set(Var("A5"), Cons(VarExp("A1"), VarExp("A4"))),
        Set(Var("A6"), Cons(VarExp("A0"), VarExp("A5"))),
        If(
          VarExp("A6"),
          List(
            Set(Var("A7"), Nl),
            Set(Var("X"), Cons(VarExp("A7"), VarExp("X"))),
            Set(Var("Y"), Cons(VarExp("X"), VarExp("X")))
          ),
          List(
            Set(Var("A8"), Nl),
            Set(Var("X"), Cons(VarExp("A8"), VarExp("X")))
          )
        )
      ),
      while1ConsCommand(
        If(
          Cons(Nl, Cons(Nl, Cons(Nl, Nl))),
          List(
            Set(Var("X"), Cons(Nl, VarExp("X"))),
            Set(Var("Y"), Cons(VarExp("X"), VarExp("X")))
          ),
          List(Set(Var("X"), Cons(Nl, VarExp("X"))))
        )
      )
    )
  }
  println("Test_while1ConsIf_1 : " + Test_while1ConsIf_1())

  def Test_while1ConsIf_2(): Boolean = {
    NewVar.reset();
    assertEquals(
      List(
        If(
          VarExp("X"),
          List(
            Set(Var("A0"), Nl),
            Set(Var("X"), Cons(VarExp("A0"), VarExp("X"))),
            Set(Var("Y"), Cons(VarExp("X"), VarExp("X")))
          ),
          List(
            Set(Var("A1"), Nl),
            Set(Var("X"), Cons(VarExp("A1"), VarExp("X")))
          )
        )
      ),
      while1ConsCommand(
        If(
          VarExp("X"),
          List(
            Set(Var("X"), Cons(Nl, VarExp("X"))),
            Set(Var("Y"), Cons(VarExp("X"), VarExp("X")))
          ),
          List(Set(Var("X"), Cons(Nl, VarExp("X"))))
        )
      )
    )
  }
  println("Test_while1ConsIf_2 : " + Test_while1ConsIf_2())

  def Test_While1ConsProgram_1(): Boolean = {
    NewVar.reset();
    assertEquals(
      Progr(
        List(Var("X")),
        List(
          Set(Var("Y"), Nl),
          While(
            VarExp("X"),
            List(
              Set(Var("A0"), Hd(VarExp("X"))),
              Set(Var("Y"), Cons(VarExp("A0"), VarExp("Y"))),
              Set(Var("X"), Tl(VarExp("X")))
            )
          )
        ),
        List(Var("Y"))
      ),
      while1ConsProgr(
        Progr(
          List(Var("X")),
          List(
            Set(Var("Y"), Nl),
            While(
              VarExp("X"),
              List(
                Set(Var("Y"), Cons(Hd(VarExp("X")), VarExp("Y"))),
                Set(Var("X"), Tl(VarExp("X")))
              )
            )
          ),
          List(Var("Y"))
        )
      )
    )
  }
  println("Test_While1ConsProgram_1 : " + Test_While1ConsProgram_1())

  def Test_prettyPrintProgram_2(): Boolean = {
    NewVar.reset();
    assertEquals(
      Progr(
        List(Var("X")),
        List(
          Set(Var("Y"), Nl),
          While(
            VarExp("X"),
            List(
              Set(Var("A0"), Hd(VarExp("X"))),
              Set(Var("Y"), Cons(VarExp("A0"), VarExp("Y"))),
              While(
                VarExp("X"),
                List(
                  Set(Var("A1"), Hd(VarExp("X"))),
                  Set(Var("Y"), Cons(VarExp("A1"), VarExp("Y"))),
                  Set(Var("X"), Tl(VarExp("X")))
                )
              ),
              Set(Var("X"), Tl(VarExp("X")))
            )
          )
        ),
        List(Var("Y"))
      ),
      while1ConsProgr(
        Progr(
          List(Var("X")),
          List(
            Set(Var("Y"), Nl),
            While(
              VarExp("X"),
              List(
                Set(Var("Y"), Cons(Hd(VarExp("X")), VarExp("Y"))),
                While(
                  VarExp("X"),
                  List(
                    Set(Var("Y"), Cons(Hd(VarExp("X")), VarExp("Y"))),
                    Set(Var("X"), Tl(VarExp("X")))
                  )
                ),
                Set(Var("X"), Tl(VarExp("X")))
              )
            )
          ),
          List(Var("Y"))
        )
      )
    )
  }
  println("Test_prettyPrintProgram_2 : " + Test_prettyPrintProgram_2())

}
