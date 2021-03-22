// SPDX-License-Identifier: Apache-2.0

package freechips.rocketchip.jtag2mm

import chisel3._
import chisel3.util._
import chisel3.util.random.LFSR
import chisel3.experimental._
import chisel3.iotesters.Driver
import chisel3.iotesters.PeekPokeTester
import org.scalatest.{FlatSpec, Matchers}
import dsptools.DspTester

class jtagFuzzerTester(dut: jtagFuzzer) extends DspTester(dut) {

  step(10)
  step(5)
  step(2500)
}


class jtagFuzzerSpec extends FlatSpec with Matchers {

  def dut(irLength: Int, beatBytes: Int, numOfTransfers: Int): () => jtagFuzzer = () => {
    new jtagFuzzer(irLength, beatBytes, numOfTransfers)
  }

  val beatBytes = 4
  val irLength = 4
  val numOfTransfers = 10
  
  it should "Test JTAG Fuzzer" in {

    //chisel3.iotesters.Driver.execute(Array("-tiwv", "-tbn", "verilator", "-tivsuv"), () => dut) { c =>
    chisel3.iotesters.Driver.execute(Array("-tbn", "verilator"), dut(irLength, beatBytes, numOfTransfers)) { c =>
      new jtagFuzzerTester(c)
    } should be(true)
  }
}
