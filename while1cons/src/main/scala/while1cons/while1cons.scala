package while1cons

import scala.util.Try

/** définition d'une exception pour le cas des listes vides
  */
case object ExceptionListeVide extends Exception

/** définition d'une exception pour le cas des listes de tailles différentes
  */
case object ExceptionListesDeLongueursDifferentes extends Exception

object While1cons {

  /*
   * UN ELIMINATEUR D'EXPRESSIONS COMPLEXES POUR LE LANGAGE WHILE
   *
   */

  /** TRAITEMENT DES EXPRESSIONS DU LANGAGE WHILE
    */

  /** @param expression
    *   : un AST décrivant une expression du langage WHILE
    * @return
    *   une paire constituée d'une liste d'affectations ayant le même effet que
    *   l'expression et une variable qui contient le résultat
    */
  // TODO PROJET 2
  def while1ConsExprV(expression: Expression): (List[Command], Variable) = ???

  /** @param expression
    *   : un AST décrivant une expression du langage WHILE
    * @return
    *   une paire constituée d'une liste d'affectations et une expression simple
    *   qui, combinées, ont le même effet que l'expression initiale
    */
  // TODO PROJET 2
  def while1ConsExprSE(expression: Expression): (List[Command], Expression) = ???


  /** TRAITEMENT DES COMMANDES DU LANGAGE WHILE
    */
  /** @param command
    *   : un AST décrivant une commande du langage WHILE
    * @return
    *   une liste de commandes ayant un seul constructeur par expression et
    *   ayant le même effet que la commande initiale
    */
  // TODO PROJET 2
  def while1ConsCommand(command: Command): List[Command] = ???

  /** @param commands
    *   : une liste non vide d'AST décrivant une liste non vide de commandes du
    *   langage WHILE
    * @return
    *   une liste de commandes ayant un seul construteur par expression et ayant
    *   le même effet que les commandes initiales
    */
  // TODO PROJET 2
  def while1ConsCommands(commands: List[Command]): List[Command] = ???

 
  /** TRAITEMENT DES PROGRAMMES DU LANGAGE WHILE
    */

  /** @param program
    *   : un AST décrivant un programme du langage WHILE
    * @return
    *   un AST décrivant un programme du langage WHILE de même sémantique que le
    *   programme initial mais ne contenant que des expressions simples
    */
  // TODO PROJET 2
  def while1ConsProgr(program: Program): Program = ???

}
