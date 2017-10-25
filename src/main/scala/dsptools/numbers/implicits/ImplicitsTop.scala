// See LICENSE for license details.

package dsptools.numbers

import chisel3.experimental.FixedPoint

trait AllSyntax extends EqSyntax with PartialOrderSyntax with OrderSyntax with SignedSyntax with IsRealSyntax with IsIntegerSyntax with
  ConvertableToSyntax with ChiselConvertableFromSyntax with BinaryRepresentationSyntax with ContextualRingSyntax

trait AllImpl extends UIntImpl with SIntImpl with FixedPointImpl with DspRealImpl with DspComplexImpl with IntervalImpl

object implicits extends AllSyntax with AllImpl with spire.syntax.AllSyntax {
}