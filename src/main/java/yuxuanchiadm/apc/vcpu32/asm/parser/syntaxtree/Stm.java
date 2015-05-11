/* Generated by JTB 1.4.7 */
package yuxuanchiadm.apc.vcpu32.asm.parser.syntaxtree;

import yuxuanchiadm.apc.vcpu32.asm.parser.visitor.*;

/**
 * JTB node class for the production Stm:<br>
 * Corresponding grammar:<br>
 * nodeChoice -> . %0 Insn()<br>
 * .......... .. | %1 LabelDef()<br>
 */
@SuppressWarnings("all")
public class Stm implements INode {

  /** Child node 1 */
  public NodeChoice nodeChoice;

  /** The serial version UID */
  private static final long serialVersionUID = 147L;

  /**
   * Constructs the node with its child node.
   *
   * @param n0 - the child node
   */
  public Stm(final NodeChoice n0) {
    nodeChoice = n0;
  }

  /**
   * Accepts the IRetArguVisitor visitor.
   *
   * @param <R> the user return type
   * @param <A> the user argument type
   * @param vis - the visitor
   * @param argu - a user chosen argument
   * @return a user chosen return information
   */
  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }

  /**
   * Accepts the IRetVisitor visitor.
   *
   * @param <R> the user return type
   * @param vis - the visitor
   * @return a user chosen return information
   */
  public <R> R accept(final IRetVisitor<R> vis) {
    return vis.visit(this);
  }

  /**
   * Accepts the IVoidArguVisitor visitor.
   *
   * @param <A> the user argument type
   * @param vis - the visitor
   * @param argu - a user chosen argument
   */
  public <A> void accept(final IVoidArguVisitor<A> vis, final A argu) {
    vis.visit(this, argu);
  }

  /**
   * Accepts the IVoidVisitor visitor.
   *
   * @param vis - the visitor
   */
  public void accept(final IVoidVisitor vis) {
    vis.visit(this);
  }

}
