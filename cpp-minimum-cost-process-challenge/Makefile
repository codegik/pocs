# Compiler
CXX = g++

# Compiler flags
CXXFLAGS = -std=c++17 -Wall -Wextra -O2

# Target executable
TARGET = app

# Source files
SRCS = MinimumCostProcess.cpp App.cpp

# Object files
OBJS = $(SRCS:.cpp=.o)

# Build target
all: $(TARGET)

# Link object files to create the executable
$(TARGET): $(OBJS)
	$(CXX) $(CXXFLAGS) -o $@ $^

# Compile source files into object files
%.o: %.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

# Clean up build files
clean:
	rm -f $(OBJS) $(TARGET)

# Clean, build, and run the application
run: clean all
	./$(TARGET)