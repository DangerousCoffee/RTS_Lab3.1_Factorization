package com.example.factor

import kotlin.math.sqrt
import kotlin.math.pow
import kotlin.math.floor

class Factor {
    public var factorized: MutableList<Long> = ArrayList()

    fun find_factor(N: Long): MutableList<Long> {
        val res: MutableList<Long> = ArrayList(2)

        val y: Long
        var x: Long = Math.round(sqrt(N.toDouble()))
        var square: Double

        for (k in 1 until N step 1) {
            square = (x + k).toDouble().pow(2) - N
            if (check_square(square)) {
                y = sqrt(square).toLong()
                x = x + k

                res.add(x - y)
                res.add(x + y)
                return res
            }
        }
        return arrayListOf(1, N)
    }

    fun prime_factor(N: Long) {
        val factors: List<Long> = find_factor(N)

        if (factors[0] != 1.toLong()) {
            prime_factor(factors[0])
            prime_factor(factors[1])
        } else factorized.add(factors[1])
    }

    private fun check_square(square: Double): Boolean {
        val root: Double = sqrt(square)
        return (root - floor(root) == 0.0)
    }
}
