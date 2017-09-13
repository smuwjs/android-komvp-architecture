package me.jeeson.android.komvp.core.utils

open class Preconditions {

    init {
        throw IllegalStateException("you can't instantiate me!")
    }

    companion object {

        fun checkArgument(expression: Boolean) {
            if (!expression) {
                throw IllegalArgumentException()
            }
        }

        fun checkArgument(expression: Boolean, errorMessage: Any?) {
            if (!expression) {
                throw IllegalArgumentException(errorMessage.toString())
            }
        }

        fun checkArgument(expression: Boolean, errorMessageTemplate: String, vararg errorMessageArgs: Any) {
            if (!expression) {
                throw IllegalArgumentException(format(errorMessageTemplate, *errorMessageArgs))
            }
        }

        fun checkState(expression: Boolean) {
            if (!expression) {
                throw IllegalStateException()
            }
        }

        fun checkState(expression: Boolean, errorMessage: Any?) {
            if (!expression) {
                throw IllegalStateException(errorMessage.toString())
            }
        }

        fun checkState(expression: Boolean, errorMessageTemplate: String, vararg errorMessageArgs: Any) {
            if (!expression) {
                throw IllegalStateException(format(errorMessageTemplate, *errorMessageArgs))
            }
        }

        fun <T> checkNotNull(reference: T?): T {
            if (reference == null) {
                throw NullPointerException()
            } else {
                return reference
            }
        }

        fun <T> checkNotNull(reference: T?, errorMessage: Any?): T {
            if (reference == null) {
                throw NullPointerException(errorMessage.toString())
            } else {
                return reference
            }
        }

        fun <T> checkNotNull(reference: T?, errorMessageTemplate: String, vararg errorMessageArgs: Any): T {
            if (reference == null) {
                throw NullPointerException(format(errorMessageTemplate, *errorMessageArgs))
            } else {
                return reference
            }
        }

        @JvmOverloads fun checkElementIndex(index: Int, size: Int, desc: String = "index"): Int {
            if (index >= 0 && index < size) {
                return index
            } else {
                throw IndexOutOfBoundsException(badElementIndex(index, size, desc))
            }
        }

        private fun badElementIndex(index: Int, size: Int, desc: String): String {
            if (index < 0) {
                return format("%s (%s) must not be negative", *arrayOf(desc, Integer.valueOf(index)))
            } else if (size < 0) {
                throw IllegalArgumentException(StringBuilder(26).append("negative size: ").append(size).toString())
            } else {
                return format("%s (%s) must be less than size (%s)", *arrayOf(desc, Integer.valueOf(index), Integer.valueOf(size)))
            }
        }

        @JvmOverloads fun checkPositionIndex(index: Int, size: Int, desc: String = "index"): Int {
            if (index >= 0 && index <= size) {
                return index
            } else {
                throw IndexOutOfBoundsException(badPositionIndex(index, size, desc))
            }
        }

        private fun badPositionIndex(index: Int, size: Int, desc: String): String {
            if (index < 0) {
                return format("%s (%s) must not be negative", *arrayOf(desc, Integer.valueOf(index)))
            } else if (size < 0) {
                throw IllegalArgumentException(StringBuilder(26).append("negative size: ").append(size).toString())
            } else {
                return format("%s (%s) must not be greater than size (%s)", *arrayOf(desc, Integer.valueOf(index), Integer.valueOf(size)))
            }
        }

        fun checkPositionIndexes(start: Int, end: Int, size: Int) {
            if (start < 0 || end < start || end > size) {
                throw IndexOutOfBoundsException(badPositionIndexes(start, end, size))
            }
        }

        private fun badPositionIndexes(start: Int, end: Int, size: Int): String {
            return if (start >= 0 && start <= size) if (end >= 0 && end <= size) format("end index (%s) must not be less than start index (%s)", *arrayOf<Any>(Integer.valueOf(end), Integer.valueOf(start))) else badPositionIndex(end, size, "end index") else badPositionIndex(start, size, "start index")
        }

        internal fun format(template1: String, vararg args: Any): String {
            var template = template1
            template = template.toString()
            val builder = StringBuilder(template.length + 16 * args.size)
            var templateStart = 0

            var i: Int
            var placeholderStart: Int
            i = 0
            while (i < args.size) {
                placeholderStart = template.indexOf("%s", templateStart)
                if (placeholderStart == -1) {
                    break
                }

                builder.append(template.substring(templateStart, placeholderStart))
                builder.append(args[i++])
                templateStart = placeholderStart + 2
            }

            builder.append(template.substring(templateStart))
            if (i < args.size) {
                builder.append(" [")
                builder.append(args[i++])

                while (i < args.size) {
                    builder.append(", ")
                    builder.append(args[i++])
                }

                builder.append(']')
            }

            return builder.toString()
        }
    }
}
