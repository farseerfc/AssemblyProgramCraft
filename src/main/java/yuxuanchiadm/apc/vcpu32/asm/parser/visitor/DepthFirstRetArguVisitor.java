/* Generated by JTB 1.4.9 */
package yuxuanchiadm.apc.vcpu32.asm.parser.visitor;

import yuxuanchiadm.apc.vcpu32.asm.parser.syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first order.<br>
 * In your "RetArgu" visitors extend this class and override part or all of these methods.
 *
 * @param <R> - The user return information type
 * @param <A> - The user argument type
 */
public class DepthFirstRetArguVisitor<R, A> implements IRetArguVisitor<R, A> {


  /*
   * Base nodes classes visit methods (to be overridden if necessary)
   */

  /**
   * Visits a {@link NodeChoice} node.
   *
   * @param n - the node to visit
   * @param argu - the user argument
   * @return the user return information
   */
  @Override
  public R visit(final NodeChoice n, final A argu) {
    /* You have to adapt which data is returned (result variables below are just examples) */
    final R nRes = n.choice.accept(this, argu);
    return nRes;
  }

  /**
   * Visits a {@link NodeList} node.
   *
   * @param n - the node to visit
   * @param argu - the user argument
   * @return the user return information
   */
  @Override
  public R visit(final NodeList n, final A argu) {
    /* You have to adapt which data is returned (result variables below are just examples) */
    R nRes = null;
    for (final Iterator<INode> e = n.elements(); e.hasNext();) {
      @SuppressWarnings("unused")
      final R sRes = e.next().accept(this, argu);
    }
    return nRes;
  }

  /**
   * Visits a {@link NodeListOptional} node.
   *
   * @param n - the node to visit
   * @param argu - the user argument
   * @return the user return information
   */
  @Override
  public R visit(final NodeListOptional n, final A argu) {
    /* You have to adapt which data is returned (result variables below are just examples) */
    if (n.present()) {
      R nRes = null;
      for (final Iterator<INode> e = n.elements(); e.hasNext();) {
        @SuppressWarnings("unused")
        R sRes = e.next().accept(this, argu);
        }
      return nRes;
    } else
      return null;
  }

  /**
   * Visits a {@link NodeOptional} node.
   *
   * @param n - the node to visit
   * @param argu - the user argument
   * @return the user return information
   */
  @Override
  public R visit(final NodeOptional n, final A argu) {
    /* You have to adapt which data is returned (result variables below are just examples) */
    if (n.present()) {
      final R nRes = n.node.accept(this, argu);
      return nRes;
    } else
      return null;
  }

  /**
   * Visits a {@link NodeSequence} node.
   *
   * @param n - the node to visit
   * @param argu - the user argument
   * @return the user return information
   */
  @Override
  public R visit(final NodeSequence n, final A argu) {
    /* You have to adapt which data is returned (result variables below are just examples) */
    R nRes = null;
    for (final Iterator<INode> e = n.elements(); e.hasNext();) {
      @SuppressWarnings("unused")
      R subRet = e.next().accept(this, argu);
    }
    return nRes;
  }

  /**
   * Visits a {@link NodeTCF} node.
   *
   * @param n - the node to visit
   * @param argu - the user argument
   * @return the user return information
   */
  @Override
  public R visit(final NodeTCF n, @SuppressWarnings("unused") final A argu) {
    /* You have to adapt which data is returned (result variables below are just examples) */
    R nRes = null;
    @SuppressWarnings("unused")
    final String tkIm = n.tokenImage;
    return nRes;
  }

  /**
   * Visits a {@link NodeToken} node.
   *
   * @param n - the node to visit
   * @param argu - the user argument
   * @return the user return information
   */
  @Override
  public R visit(final NodeToken n, @SuppressWarnings("unused") final A argu) {
    /* You have to adapt which data is returned (result variables below are just examples) */
    R nRes = null;
    @SuppressWarnings("unused")
    final String tkIm = n.tokenImage;
    return nRes;
  }

  /*
   * User grammar generated visit methods (to be overridden if necessary)
   */

  /**
   * Visits a {@link AbstractSyntaxTree} node, whose children are the following :
   * <p>
   * nodeOptional -> ( StmList() )?<br>
   * nodeToken -> <EOF><br>
   *
   * @param n - the node to visit
   * @param argu - the user argument
   * @return the user return information
   */
  @Override
  public R visit(final AbstractSyntaxTree n, final A argu) {
    R nRes = null;
    // nodeOptional -> ( StmList() )?
    final NodeOptional n0 = n.nodeOptional;
    if (n0.present()) {
      nRes = n0.accept(this, argu);
    }
    // nodeToken -> <EOF>
    final NodeToken n1 = n.nodeToken;
    nRes = n1.accept(this, argu);
    return nRes;
  }

  /**
   * Visits a {@link StmList} node, whose children are the following :
   * <p>
   * stm -> Stm()<br>
   * nodeOptional -> ( StmList() )?<br>
   *
   * @param n - the node to visit
   * @param argu - the user argument
   * @return the user return information
   */
  @Override
  public R visit(final StmList n, final A argu) {
    R nRes = null;
    // stm -> Stm()
    final Stm n0 = n.stm;
    nRes = n0.accept(this, argu);
    // nodeOptional -> ( StmList() )?
    final NodeOptional n1 = n.nodeOptional;
    if (n1.present()) {
      nRes = n1.accept(this, argu);
    }
    return nRes;
  }

  /**
   * Visits a {@link Stm} node, whose child is the following :
   * <p>
   * nodeChoice -> . %0 Insn()<br>
   * .......... .. | %1 LabelDef()<br>
   *
   * @param n - the node to visit
   * @param argu - the user argument
   * @return the user return information
   */
  @Override
  public R visit(final Stm n, final A argu) {
    R nRes = null;
    // nodeChoice -> . %0 Insn()
    // .......... .. | %1 LabelDef()
    final NodeChoice nch = n.nodeChoice;
    final INode ich = nch.choice;
    switch (nch.which) {
      case 0:
        // %0 Insn()
        nRes = ich.accept(this, argu);
        break;
      case 1:
        // %1 LabelDef()
        nRes = ich.accept(this, argu);
        break;
      default:
        // should not occur !!!
        break;
    }
    return nRes;
  }

  /**
   * Visits a {@link Insn} node, whose children are the following :
   * <p>
   * nodeToken -> <Opt><br>
   * nodeOptional -> ( ParList() )?<br>
   *
   * @param n - the node to visit
   * @param argu - the user argument
   * @return the user return information
   */
  @Override
  public R visit(final Insn n, final A argu) {
    R nRes = null;
    // nodeToken -> <Opt>
    final NodeToken n0 = n.nodeToken;
    nRes = n0.accept(this, argu);
    // nodeOptional -> ( ParList() )?
    final NodeOptional n1 = n.nodeOptional;
    if (n1.present()) {
      nRes = n1.accept(this, argu);
    }
    return nRes;
  }

  /**
   * Visits a {@link LabelDef} node, whose children are the following :
   * <p>
   * nodeToken -> <LabelBegin><br>
   * nodeToken1 -> <Label><br>
   *
   * @param n - the node to visit
   * @param argu - the user argument
   * @return the user return information
   */
  @Override
  public R visit(final LabelDef n, final A argu) {
    R nRes = null;
    // nodeToken -> <LabelBegin>
    final NodeToken n0 = n.nodeToken;
    nRes = n0.accept(this, argu);
    // nodeToken1 -> <Label>
    final NodeToken n1 = n.nodeToken1;
    nRes = n1.accept(this, argu);
    return nRes;
  }

  /**
   * Visits a {@link ParList} node, whose children are the following :
   * <p>
   * par -> Par()<br>
   * nodeOptional -> ( #0 <Comma> #1 ParList() )?<br>
   *
   * @param n - the node to visit
   * @param argu - the user argument
   * @return the user return information
   */
  @Override
  public R visit(final ParList n, final A argu) {
    R nRes = null;
    // par -> Par()
    final Par n0 = n.par;
    nRes = n0.accept(this, argu);
    // nodeOptional -> ( #0 <Comma> #1 ParList() )?
    final NodeOptional n1 = n.nodeOptional;
    if (n1.present()) {
      final NodeSequence seq = (NodeSequence) n1.node;
      // #0 <Comma>
      final INode seq1 = seq.elementAt(0);
      nRes = seq1.accept(this, argu);
      // #1 ParList()
      final INode seq2 = seq.elementAt(1);
      nRes = seq2.accept(this, argu);
    }
    return nRes;
  }

  /**
   * Visits a {@link Par} node, whose child is the following :
   * <p>
   * nodeChoice -> . %0 <Dec><br>
   * .......... .. | %1 <Hex><br>
   * .......... .. | %2 <Oct><br>
   * .......... .. | %3 <Bin><br>
   * .......... .. | %4 <Reg><br>
   * .......... .. | %5 #0 <MemBegin><br>
   * .......... .. . .. #1 ( &0 <Reg><br>
   * .......... .. . .. .. | &1 <Dec><br>
   * .......... .. . .. .. | &2 <Hex><br>
   * .......... .. . .. .. | &3 <Oct><br>
   * .......... .. . .. .. | &4 <Bin> )<br>
   * .......... .. . .. #2 <MemEnd><br>
   * .......... .. | %6 <String><br>
   * .......... .. | %7 <Char><br>
   * .......... .. | %8 <Label><br>
   * .......... .. | %9 <Real><br>
   *
   * @param n - the node to visit
   * @param argu - the user argument
   * @return the user return information
   */
  @Override
  public R visit(final Par n, final A argu) {
    R nRes = null;
    // nodeChoice -> . %0 <Dec>
    // .......... .. | %1 <Hex>
    // .......... .. | %2 <Oct>
    // .......... .. | %3 <Bin>
    // .......... .. | %4 <Reg>
    // .......... .. | %5 #0 <MemBegin>
    // .......... .. . .. #1 ( &0 <Reg>
    // .......... .. . .. .. | &1 <Dec>
    // .......... .. . .. .. | &2 <Hex>
    // .......... .. . .. .. | &3 <Oct>
    // .......... .. . .. .. | &4 <Bin> )
    // .......... .. . .. #2 <MemEnd>
    // .......... .. | %6 <String>
    // .......... .. | %7 <Char>
    // .......... .. | %8 <Label>
    // .......... .. | %9 <Real>
    final NodeChoice nch = n.nodeChoice;
    final INode ich = nch.choice;
    switch (nch.which) {
      case 0:
        // %0 <Dec>
        nRes = ich.accept(this, argu);
        break;
      case 1:
        // %1 <Hex>
        nRes = ich.accept(this, argu);
        break;
      case 2:
        // %2 <Oct>
        nRes = ich.accept(this, argu);
        break;
      case 3:
        // %3 <Bin>
        nRes = ich.accept(this, argu);
        break;
      case 4:
        // %4 <Reg>
        nRes = ich.accept(this, argu);
        break;
      case 5:
        // %5 #0 <MemBegin>
        // .. #1 ( &0 <Reg>
        // .. .. | &1 <Dec>
        // .. .. | &2 <Hex>
        // .. .. | &3 <Oct>
        // .. .. | &4 <Bin> )
        // .. #2 <MemEnd>
        final NodeSequence seq = (NodeSequence) ich;
        // #0 <MemBegin>
        final INode seq1 = seq.elementAt(0);
        nRes = seq1.accept(this, argu);
        // #1 ( &0 <Reg>
        // .. | &1 <Dec>
        // .. | &2 <Hex>
        // .. | &3 <Oct>
        // .. | &4 <Bin> )
        final INode seq2 = seq.elementAt(1);
        final NodeChoice nch1 = (NodeChoice) seq2;
        final INode ich1 = nch1.choice;
        switch (nch1.which) {
          case 0:
            // &0 <Reg>
            nRes = ich1.accept(this, argu);
            break;
          case 1:
            // &1 <Dec>
            nRes = ich1.accept(this, argu);
            break;
          case 2:
            // &2 <Hex>
            nRes = ich1.accept(this, argu);
            break;
          case 3:
            // &3 <Oct>
            nRes = ich1.accept(this, argu);
            break;
          case 4:
            // &4 <Bin>
            nRes = ich1.accept(this, argu);
            break;
          default:
            // should not occur !!!
            break;
        }
        // #2 <MemEnd>
        final INode seq3 = seq.elementAt(2);
        nRes = seq3.accept(this, argu);
        break;
      case 6:
        // %6 <String>
        nRes = ich.accept(this, argu);
        break;
      case 7:
        // %7 <Char>
        nRes = ich.accept(this, argu);
        break;
      case 8:
        // %8 <Label>
        nRes = ich.accept(this, argu);
        break;
      case 9:
        // %9 <Real>
        nRes = ich.accept(this, argu);
        break;
      default:
        // should not occur !!!
        break;
    }
    return nRes;
  }

}
